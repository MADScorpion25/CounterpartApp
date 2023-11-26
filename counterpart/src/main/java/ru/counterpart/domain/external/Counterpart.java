package ru.counterpart.domain.external;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.counterpart.domain.ContractStatus;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Данные контракта")
public class Counterpart {

    @NotBlank
    @Parameter(description = "Имя заказчика", required = true)
    private String partnerName;

    @NotNull
    @Parameter(description = "Номер контракта", required = true)
    private BigInteger contractNumber;

    @NotNull
    @Parameter(description = "Статус контракта", required = true)
    private ContractStatus contractStatus;

    @NotBlank
    @Parameter(description = "Имя менеджера", required = true)
    private String manager;
}
