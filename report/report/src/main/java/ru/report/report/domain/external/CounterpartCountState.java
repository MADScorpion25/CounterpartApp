package ru.report.report.domain.external;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.report.report.domain.ContractStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
@Schema(description = "Кол-во договоров по статусу")
public class CounterpartCountState {

    @NotNull
    @Parameter(description = "Статус договора")
    private ContractStatus status;

    @NotNull
    @Parameter(description = "Кол-во договоров")
    private Long count;
}
