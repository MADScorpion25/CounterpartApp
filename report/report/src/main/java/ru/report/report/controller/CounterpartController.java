package ru.report.report.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import ru.report.report.domain.external.Counterpart;

import java.util.List;

@Validated
public interface CounterpartController {


    @GetMapping("/counterpart")
    @Operation(summary = "Выводит все договора")
    List<Counterpart> getCounterparts();
}
