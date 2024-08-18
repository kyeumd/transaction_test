package com.example.transaction_test.order.model.service;

import com.example.transaction_test.coupon.infra.CouponRepository;
import com.example.transaction_test.coupon.model.domain.CouponHistory;
import com.example.transaction_test.order.infra.OrderRepository;
import com.example.transaction_test.order.model.domain.Order;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;
import jakarta.transaction.TransactionManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CouponRepository couponRepository;
    @Transactional
    public void tradeTest(int userId , int buyAmt, int couponId) throws SystemException {
        Order order = Order.create(userId, buyAmt);
        orderRepository.save(order);
        TransactionSynchronizationManager.isActualTransactionActive();
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();

//        orderRepository.callMyStoredProcedure(userId);
        String currentTransactionName1 = TransactionSynchronizationManager.getCurrentTransactionName();

        if (userId == 22) {
            throw new RuntimeException("ohh exception");
        }

        CouponHistory couponHistory = CouponHistory.create(order.getId(), userId, couponId);
        couponRepository.save(couponHistory);
        String currentTransactionName2 = TransactionSynchronizationManager.getCurrentTransactionName();
    }
}
