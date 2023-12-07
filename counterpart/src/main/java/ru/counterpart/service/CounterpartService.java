package ru.counterpart.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.counterpart.domain.ContractStatus;
import ru.counterpart.domain.CounterpartEntity;
import ru.counterpart.domain.external.Counterpart;
import ru.counterpart.domain.external.ManagerSetRequest;
import ru.counterpart.exception.CounterpartAlreadyExistsException;
import ru.counterpart.exception.CounterpartNotFoundException;
import ru.counterpart.mapper.CounterpartMapper;
import ru.counterpart.repositoty.CounterpartRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CounterpartService {
    private final CounterpartRepository counterpartRepository;
    private final CounterpartMapper counterpartMapper;

    @Transactional
    public Counterpart saveCounterpart(Counterpart counterpart) {
        if (counterpartRepository.existsByContractNumber(counterpart.getContractNumber())) {
            throw new CounterpartAlreadyExistsException("Контракт с номером %s уже существует", counterpart.getContractNumber());
        }
        CounterpartEntity counterpartEntity = counterpartMapper.toEntity(counterpart);
        counterpartEntity.setContractStatus(ContractStatus.OPENED);
        CounterpartEntity savedCounterpart = counterpartRepository.save(counterpartEntity);
        return counterpartMapper.toDto(savedCounterpart);
    }

    @Transactional(readOnly = true)
    public List<Counterpart> findAllCounterparts() {
        return counterpartRepository.findAll().stream()
                .map(counterpartMapper::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public Counterpart findCounterpartByNumber(BigInteger contractNumber) {
        CounterpartEntity counterpartEntity = findCounterpartOrThrows(contractNumber);
        return counterpartMapper.toDto(counterpartEntity);
    }

    @Transactional
    public Counterpart updateCounterpart(Counterpart counterpart, BigInteger number) {
        CounterpartEntity counterpartEntity = findCounterpartOrThrows(number);

        CounterpartEntity counterpartToUpdate = counterpartMapper.toEntity(counterpart);
        counterpartToUpdate.setId(counterpartEntity.getId());
        return refreshCounterpart(counterpartEntity);
    }

    @Transactional
    public void deleteCounterpart(BigInteger counterpartNumber) {
        counterpartRepository.deleteByContractNumber(counterpartNumber);
    }

    @Transactional
    public Counterpart closeCounterpart(BigInteger counterpartNumber) {
        CounterpartEntity counterpartEntity = findCounterpartOrThrows(counterpartNumber);

        counterpartEntity.setContractStatus(ContractStatus.CLOSED);
        return refreshCounterpart(counterpartEntity);
    }

    @Transactional
    public Counterpart updateManager(ManagerSetRequest managerSetRequest) {
        BigInteger contractNumber = managerSetRequest.getContractNumber();
        CounterpartEntity counterpartEntity = findCounterpartOrThrows(contractNumber);

        counterpartEntity.setManager(managerSetRequest.getManager());
        return refreshCounterpart(counterpartEntity);
    }

    private CounterpartEntity findCounterpartOrThrows(BigInteger counterpartNumber) {
        return counterpartRepository.findByContractNumber(counterpartNumber)
                .orElseThrow(() ->
                        new CounterpartNotFoundException("Контракт с номером %s не найден", counterpartNumber));
    }

    private Counterpart refreshCounterpart(CounterpartEntity counterpartEntity) {
        CounterpartEntity savedCounterpart = counterpartRepository.save(counterpartEntity);
        return counterpartMapper.toDto(savedCounterpart);
    }
}
