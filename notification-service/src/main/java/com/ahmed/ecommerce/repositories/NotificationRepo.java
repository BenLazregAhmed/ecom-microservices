package com.ahmed.ecommerce.repositories;

import com.ahmed.ecommerce.entities.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepo extends MongoRepository<Notification,String> {
}
