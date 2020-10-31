package com.zurum.modernbank.repository;

import com.zurum.modernbank.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(@NotBlank @Email String email);
}
