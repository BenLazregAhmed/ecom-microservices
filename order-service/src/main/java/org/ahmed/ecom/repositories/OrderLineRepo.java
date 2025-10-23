package org.ahmed.ecom.repositories;

import org.ahmed.ecom.dtos.OrderLineResponse;
import org.ahmed.ecom.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLineRepo extends JpaRepository<OrderLine,Integer> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
