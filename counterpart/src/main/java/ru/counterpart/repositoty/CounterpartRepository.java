package ru.counterpart.repositoty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.counterpart.domain.CounterpartEntity;

import java.math.BigInteger;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CounterpartRepository extends JpaRepository<CounterpartEntity, UUID> {

    Optional<CounterpartEntity> findByContractNumber(BigInteger contractNumber);

    void deleteByContractNumber(BigInteger contractNumber);

    boolean existsByContractNumber(BigInteger contractNumber);
}
