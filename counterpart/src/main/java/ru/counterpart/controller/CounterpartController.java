package ru.counterpart.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.counterpart.domain.external.Counterpart;

import java.math.BigInteger;
import java.util.List;

@Validated
public interface CounterpartController {

    @PostMapping("/counterpart")
    @Operation(summary = "Создает контракт")
    Counterpart createCounterpart(@Parameter(description = "Данные для создания контракта")
                                  @Validated @NotNull @RequestBody Counterpart counterpart);

    @PutMapping("/counterpart/{contractNumber}")
    @Operation(summary = "Обновляет данные контракта")
    Counterpart updateCounterpart(@Parameter(description = "Номер договора")
                                  @Valid @NotNull @PathVariable("contractNumber") BigInteger contractNumber,
                                  @Parameter(description = "Данные для обновления контракта")
                                  @Validated @NotNull @RequestBody Counterpart counterpart);

    @GetMapping("/counterpart/{contractNumber}")
    @Operation(summary = "Поиск договора по номеру")
    Counterpart getCounterpart(@Parameter(description = "Номер договора", required = true)
                               @Valid @NotNull @PathVariable("contractNumber") BigInteger contractNumber);

    @GetMapping("/counterpart")
    @Operation(summary = "Выводит все договора")
    List<Counterpart> getCounterparts();

    @DeleteMapping("/counterpart/{contractNumber}")
    void deleteCounterpart(@Parameter(description = "Номер договора", required = true)
                           @Valid @NotNull @PathVariable("contractNumber") BigInteger contractNumber);

    @GetMapping("/report")
    ResponseEntity<byte[]> createReport();

}
