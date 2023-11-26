package ru.report.report.mapper;

import org.mapstruct.Mapper;
import ru.report.report.domain.CounterpartEntity;
import ru.report.report.domain.external.Counterpart;

@Mapper(componentModel = "spring")
public interface CounterpartMapper {

    CounterpartEntity toEntity(Counterpart dto);

    Counterpart toDto(CounterpartEntity entity);
}
