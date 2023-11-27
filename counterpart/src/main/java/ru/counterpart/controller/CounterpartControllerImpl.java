package ru.counterpart.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.counterpart.domain.external.Counterpart;
import ru.counterpart.service.CounterpartService;
import ru.counterpart.service.FileserviceAdapterService;
import ru.counterpart.service.ReportAdapterService;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CounterpartControllerImpl implements CounterpartController {
    private final CounterpartService counterpartService;
    private final ReportAdapterService reportAdapterService;
    private final FileserviceAdapterService fileserviceAdapterService;

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
    public ResponseEntity<byte[]> createReport() {
        return ResponseEntity.ok(reportAdapterService.getReport());
    }

    @Override
    public void uploadReport() {
        fileserviceAdapterService.uploadReport();
    }
}
