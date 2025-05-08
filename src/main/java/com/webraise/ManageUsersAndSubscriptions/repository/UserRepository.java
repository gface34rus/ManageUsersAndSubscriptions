package com.webraise.ManageUsersAndSubscriptions.repository;

import com.webraise.ManageUsersAndSubscriptions.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
