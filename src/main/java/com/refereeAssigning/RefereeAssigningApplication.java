package com.refereeAssigning;

import com.refereeAssigning.model.User;
import com.refereeAssigning.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RefereeAssigningApplication {
    public static void main(String[] args) {
        SpringApplication.run(RefereeAssigningApplication.class, args);
    }

    /*@Bean
    CommandLineRunner testUserRepository(UserRepository userRepository) {
        return args -> {
            User user = new User();
            user.setName("John Doe");
            user.setEmail("test.subject@gmail.com".toLowerCase());
            user.setHashedPassword("abc123");
            user.setRole(User.Role.REFEREE);
            user.setWage(50.0);

            userRepository.save(user);

            userRepository.findByEmail("test.subject@gmail.com").ifPresent(u -> System.out.println("User found: " + u.getName()));
        };*/
    @Bean
    CommandLineRunner testUserRepository(UserRepository userRepository) {
        return args -> {
            User user = new User();
            user.setUserId(5L);
            user.setName("John Doe");
            user.setEmail("test.subject@gmail.com".toLowerCase());
            user.setHashedPassword("abc123");
            user.setRole(User.Role.REFEREE);
            user.setWage(50.0);

            userRepository.save(user);

            userRepository.findByName("John Doe").ifPresent(u -> System.out.println("User found: " + u.getName()));
        };

    }
}

