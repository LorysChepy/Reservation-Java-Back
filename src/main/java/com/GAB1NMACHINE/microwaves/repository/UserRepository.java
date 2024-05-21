package com.GAB1NMACHINE.microwaves.repository;

import com.GAB1NMACHINE.microwaves.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
