package com.example.transaction_test.order.model.service;


import jakarta.transaction.SystemException;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("거래내역을 생성한다.")
    void createOrderHistory() throws SystemException {
        int userId = 22;
        int totalAmount = 99000;
        int couponId = 44;
        orderService.tradeTest(userId, totalAmount,couponId);
    }
}