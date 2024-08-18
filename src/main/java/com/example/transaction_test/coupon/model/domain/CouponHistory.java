package com.example.transaction_test.coupon.model.domain;

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
@Table(name = "CouponHistory_Test")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CouponHistoryId")
    private Long id;
    private int userId;
    private long orderId;
    private int couponId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private int createdBy;
    private int modifiedBy;

    private CouponHistory(Long id, long orderId, int userId, int couponId, LocalDateTime createdDate, LocalDateTime modifiedDate, int createdBy,
        int modifiedBy) {
        this.id = id;
        this.orderId = orderId;
        this.userId = userId;
        this.couponId = couponId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public static CouponHistory create(long orderId,int userId, int couponId) {
        return new CouponHistory(
            null,
            orderId,
            userId,
            couponId,
            LocalDateTime.now(),
            LocalDateTime.now(),
            userId,
            userId);
    }
}
