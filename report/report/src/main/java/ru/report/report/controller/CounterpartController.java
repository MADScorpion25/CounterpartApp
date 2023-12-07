package ru.report.report.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import ru.report.report.domain.external.Counterpart;
import ru.report.report.domain.external.CounterpartCountState;

import java.util.List;

@Validated
public interface CounterpartController {

    @GetMapping("/counterpart")
    @Operation(summary = "Выводит кол-во договоров по статусам")
    List<CounterpartCountState> getCounterparts();

    @GetMapping("/counterparts")
    @Operation(summary = "Формирует ответ в формате csv")
    ResponseEntity<byte[]> getReportInCsv();
}
