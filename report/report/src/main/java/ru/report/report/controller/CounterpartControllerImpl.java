package ru.report.report.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.report.report.domain.external.CounterpartCountState;
import ru.report.report.service.CounterpartService;
import ru.report.report.service.CsvExportService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CounterpartControllerImpl implements CounterpartController {
    private final CounterpartService counterpartService;
    private final CsvExportService csvExportService;

    @Override
    public List<CounterpartCountState> getCounterparts() {
        return counterpartService.findAllCounterparts();
    }

    @Override
    public ResponseEntity<byte[]> getReportInCsv() {
        return ResponseEntity.ok(csvExportService.writeEmployeesToCsv());
    }
}
