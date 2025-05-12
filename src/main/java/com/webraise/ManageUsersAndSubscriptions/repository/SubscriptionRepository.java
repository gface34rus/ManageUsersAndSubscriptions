package com.webraise.ManageUsersAndSubscriptions.repository;

import com.webraise.ManageUsersAndSubscriptions.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUserId(Long userId);

    @Query("SELECT s FROM Subscription s JOIN s.user u GROUP BY s.id ORDER BY COUNT(u) DESC")
    List<Subscription> findTop3ByUserCount();
}
