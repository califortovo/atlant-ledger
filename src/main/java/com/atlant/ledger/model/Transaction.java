package com.atlant.ledger.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "t_transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
//
//    @ManyToOne
//    private Account account;

    @Column
    private LocalDateTime timestamp;

    @Column
    private Double value;

//    @ManyToOne
//    private Category category;

    public Transaction(LocalDateTime timestamp, Double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

}
