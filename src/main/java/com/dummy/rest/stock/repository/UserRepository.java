package com.dummy.rest.stock.repository;

import java.util.Optional;

import com.dummy.rest.stock.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    // ! Important
    
    Optional<User> findByUsername(String username);
}

