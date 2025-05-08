package com.webraise.ManageUsersAndSubscriptions.controller;

import com.webraise.ManageUsersAndSubscriptions.model.Subscription;
import com.webraise.ManageUsersAndSubscriptions.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/subscriptions")
public class SubscriptionController {
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @PostMapping
    public Subscription addSubscription(@PathVariable Long userId, @RequestBody Subscription subscription) {
        subscription.setUser(new User(userId)); // Assuming User has a constructor that accepts id
        return subscriptionRepository.save(subscription);
    }

    @GetMapping
    public List<Subscription> getUserSubscriptions(@PathVariable Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }

    @DeleteMapping("/{sub_id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long userId, @PathVariable Long sub_id) {
        subscriptionRepository.deleteById(sub_id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/top")
    public List<Subscription> getTopSubscriptions() {
        // Implement logic to get top subscriptions
        return subscriptionRepository.findTop3ByOrderBySomeCriteria(); // Placeholder
    }
}
