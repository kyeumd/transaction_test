package com.example.transaction_test.order.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "OrderHistory_Test")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private Long id;
    private int userId;
    private int buyAmount;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private int createdBy;
    private int modifiedBy;

    private Order(Long id, int userId, int buyAmount, LocalDateTime createdDate, LocalDateTime modifiedDate, int createdBy,
        int modifiedBy) {
        this.id = id;
        this.userId = userId;
        this.buyAmount = buyAmount;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public static Order create(int userId, int buyAmount) {
        return new Order(
            null,
            userId,
            buyAmount,
            LocalDateTime.now(),
            LocalDateTime.now(),
            userId,
            userId
            );
    }
}
