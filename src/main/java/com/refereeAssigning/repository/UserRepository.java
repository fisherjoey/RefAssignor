package com.refereeAssigning.repository;

import com.refereeAssigning.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//TODO As needed, create more queries
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by email
    Optional<User> findByEmail(String email);

    // Find a user by their name
    Optional<User> findByName(String name);

    boolean existsByEmail(String email);
}