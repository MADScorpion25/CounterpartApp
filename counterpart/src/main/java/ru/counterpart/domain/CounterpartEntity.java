package ru.counterpart.domain;

import jakarta.persistence.*;
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
