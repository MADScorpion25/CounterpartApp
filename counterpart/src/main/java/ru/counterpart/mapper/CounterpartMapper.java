package ru.counterpart.mapper;

import org.mapstruct.Mapper;
import ru.counterpart.domain.CounterpartEntity;
import ru.counterpart.domain.external.Counterpart;

@Mapper(componentModel = "spring")
public interface CounterpartMapper {

    CounterpartEntity toEntity(Counterpart dto);

    Counterpart toDto(CounterpartEntity entity);
}
