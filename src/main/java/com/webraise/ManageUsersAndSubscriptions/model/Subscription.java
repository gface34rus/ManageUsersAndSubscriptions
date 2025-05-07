package com.webraise.ManageUsersAndSubscriptions.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "subscriptions")
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(serviceName, that.serviceName) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, user);
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + id +
                ", serviceName='" + serviceName + '\'' +
                ", user=" + user +
                '}';
    }
}
