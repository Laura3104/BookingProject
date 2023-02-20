package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.dao.UserAccountDAO;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountDAO, Long> {}
