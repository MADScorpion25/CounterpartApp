package ru.counterpart.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "counterpart")
public class CounterpartEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "partner_name", nullable = false)
    private String partnerName;

    @Column(name = "contract_number", nullable = false, unique = true)
    private BigInteger contractNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "contract_status", nullable = false)
    private ContractStatus contractStatus;

    @Column(name = "manager", nullable = false)
    private String manager;
}
