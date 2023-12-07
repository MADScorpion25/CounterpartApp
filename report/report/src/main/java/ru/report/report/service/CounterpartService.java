package ru.report.report.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.report.report.domain.ContractStatus;
import ru.report.report.domain.external.Counterpart;
import ru.report.report.domain.external.CounterpartCountState;
import ru.report.report.mapper.CounterpartMapper;
import ru.report.report.repositoty.CounterpartRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CounterpartService {
    private final CounterpartRepository counterpartRepository;
    private final CounterpartMapper counterpartMapper;

    @Transactional(readOnly = true)
    public List<CounterpartCountState> findAllCounterparts() {
        Map<ContractStatus, Long> contractsCountingByState = counterpartRepository.findAll().stream()
                .map(counterpartMapper::toDto)
                .collect(Collectors.groupingBy(Counterpart::getContractStatus, Collectors.counting()));

        return contractsCountingByState.entrySet().stream()
                .map(countState -> CounterpartCountState.of(countState.getKey(), countState.getValue()))
                .toList();
    }
}
