package org.ahmed.ecom.repositories;

import org.ahmed.ecom.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Integer> {
}
