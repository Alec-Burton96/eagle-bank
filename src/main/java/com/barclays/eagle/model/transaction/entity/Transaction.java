package com.barclays.eagle.model.transaction.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "Transactions")
public class Transaction {

    public Transaction(double amount, String currency, String type, String reference, String userId, String accountNumber) {
        this.amount = amount;
        this.currency = currency;
        this.type = type;
        this.reference = reference;
        this.userId = userId;
        this.accountNumber = accountNumber;
    }

    @Id
    private String id;
    @PrePersist
    public void generateId() {
        if (id == null) {
           id = "tan-" + UUID.randomUUID().toString()
                   .replace("-", "")
                   .substring(0, 6);
        }
    }
    private double amount;
    private String currency;
    private String type;
    private String reference;
    private String userId;
    @CreationTimestamp
    private LocalDateTime createdTimestamp;
    @Pattern(regexp = "^01\\d{6}$")
    private String accountNumber;
}
