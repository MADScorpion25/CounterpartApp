package ru.report.report.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.report.report.domain.CounterpartEntity;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CounterpartRepository extends JpaRepository<CounterpartEntity, UUID> {
}
