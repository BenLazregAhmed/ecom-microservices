package org.ahmed.ecom.repositories;

import org.ahmed.ecom.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {
}
