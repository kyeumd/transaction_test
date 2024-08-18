package com.example.transaction_test.coupon.infra;

import com.example.transaction_test.coupon.model.domain.CouponHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<CouponHistory, Long> {
}
