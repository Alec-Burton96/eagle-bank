package com.barclays.eagle.model.account.entity;

import com.barclays.eagle.model.user.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue

    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
    private String userId;

    private String name;
    private String accountType;

    @Pattern(regexp = "^01\\d{6}$")
    private String accountNumber;

    @PrePersist
    public void generateAccountNumber() {
        if (accountNumber == null) {
            int randomNumber = (int) (Math.random() * 1_000_000); // 0 → 999999
            this.accountNumber = String.format("01%06d", randomNumber);
        }
    }

    private String sortCode;

    public Account(String name, String accountType, String sortCode, double balance, String currency, String userId) {
        this.name = name;
        this.accountType = accountType;
        this.sortCode = sortCode;
        this.balance = balance;
        this.currency = currency;
        this.userId = userId;
    }

    private double balance;
    private String currency;

    @CreationTimestamp
    private LocalDateTime createdTimestamp;
    @UpdateTimestamp
    private LocalDateTime updatedTimestamp;

}
