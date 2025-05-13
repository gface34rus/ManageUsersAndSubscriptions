package com.webraise.ManageUsersAndSubscriptions.controller;

import com.webraise.ManageUsersAndSubscriptions.model.Subscription;
import com.webraise.ManageUsersAndSubscriptions.model.User;
import com.webraise.ManageUsersAndSubscriptions.repository.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
public class SubscriptionController {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @PostMapping
    public Subscription addSubscription(@PathVariable Long userId, @RequestBody Subscription subscription) {
        subscription.setUser(new User(userId)); // Assuming User has a constructor that accepts id
        logger.info("Adding subscription for userId: {}", userId);
        return subscriptionRepository.save(subscription);
    }


    @GetMapping
    public List<Subscription> getUserSubscriptions(@PathVariable Long userId) {
        logger.info("Retrieving subscriptions for userId: {}", userId);
        return subscriptionRepository.findByUserId(userId);
    }


    @DeleteMapping("/{sub_id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long userId, @PathVariable Long sub_id) {
        logger.info("Deleting subscription with id: {} for userId: {}", sub_id, userId);
        subscriptionRepository.deleteById(sub_id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/top")
    public List<Subscription> getTopSubscriptions() {
        logger.info("Retrieving top 3 subscriptions by user count");
        return subscriptionRepository.findTop3ByUserCount();
    }
}
