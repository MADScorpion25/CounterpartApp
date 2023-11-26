package ru.report.report.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.report.report.domain.external.Counterpart;
import ru.report.report.service.CounterpartService;
import ru.report.report.service.CsvExportService;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class CounterpartControllerImpl implements CounterpartController {
    private final CounterpartService counterpartService;
    private final CsvExportService csvExportService;

    @Override
    public List<Counterpart> getCounterparts() {
        return counterpartService.findAllCounterparts();
    }

    @GetMapping("/counterparts")
    public ResponseEntity<byte[]> getAllEmployeesInCsv() {
        return ResponseEntity.ok(csvExportService.writeEmployeesToCsv());
    }
}
