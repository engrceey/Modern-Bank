package com.zurum.modernbank.repository;

import com.zurum.modernbank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
