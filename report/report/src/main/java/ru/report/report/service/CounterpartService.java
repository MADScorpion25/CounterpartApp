package ru.report.report.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.report.report.domain.external.Counterpart;
import ru.report.report.mapper.CounterpartMapper;
import ru.report.report.repositoty.CounterpartRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CounterpartService {
    private final CounterpartRepository counterpartRepository;
    private final CounterpartMapper counterpartMapper;

    @Transactional(readOnly = true)
    public List<Counterpart> findAllCounterparts() {
        return counterpartRepository.findAll().stream()
                .map(counterpartMapper::toDto)
                .collect(Collectors.toList());
    }
}
