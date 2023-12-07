package ru.counterpart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.counterpart.domain.external.Counterpart;
import ru.counterpart.domain.external.ManagerSetRequest;
import ru.counterpart.service.CounterpartService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CounterpartControllerImpl implements CounterpartController {
    private final CounterpartService counterpartService;

    @Override
    public Counterpart createCounterpart(Counterpart counterpart) {
        return counterpartService.saveCounterpart(counterpart);
    }

    @Override
    public Counterpart updateCounterpart(BigInteger contractNumber, Counterpart counterpart) {
        return counterpartService.updateCounterpart(counterpart, contractNumber);
    }

    @Override
    public Counterpart getCounterpart(BigInteger contractNumber) {
        return counterpartService.findCounterpartByNumber(contractNumber);
    }

    @Override
    public List<Counterpart> getCounterparts() {
        return counterpartService.findAllCounterparts();
    }

    @Override
    public void deleteCounterpart(BigInteger contractNumber) {
        counterpartService.deleteCounterpart(contractNumber);
    }

    @Override
    public Counterpart closeCounterpart(BigInteger contractNumber) {
        return counterpartService.closeCounterpart(contractNumber);
    }

    @Override
    public Counterpart setManager(ManagerSetRequest managerSetRequest) {
        return counterpartService.updateManager(managerSetRequest);
    }
}
