package org.ahmed.ecom.services;

import lombok.RequiredArgsConstructor;
import org.ahmed.ecom.dtos.PaymentRequest;
import org.ahmed.ecom.kafka.NotificationProducer;
import org.ahmed.ecom.kafka.PaymentNotificationRequest;
import org.ahmed.ecom.mappers.PaymentMapper;
import org.ahmed.ecom.repositories.PaymentRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepo paymentRepo;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;
    public Integer createPayment(PaymentRequest request) {
        var paymentId= paymentRepo.save(mapper.toPayment(request)).getId();

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstName(),
                        request.customer().LastName(),
                        request.customer().email()
                )
        );
        return paymentId;
    }
}
