package com.example.transaction_test.order.infra;

import com.example.transaction_test.order.model.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    @Modifying
    @Query(value = "EXEC P_Point_Test :param1 ", nativeQuery = true)
    void callMyStoredProcedure(@Param("param1") int userId);
}
