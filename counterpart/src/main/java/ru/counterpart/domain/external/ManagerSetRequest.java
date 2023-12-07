package ru.counterpart.domain.external;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigInteger;

@Data
@Schema(description = "Данные для назначения ответственного")
public class ManagerSetRequest {

    @NotNull
    @Parameter(description = "Номер договора", required = true)
    private BigInteger contractNumber;

    @NotBlank
    @Parameter(description = "Ф.И.О. ответственного", required = true)
    private String manager;
}
