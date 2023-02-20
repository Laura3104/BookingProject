package com.example.spring.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.dao.UserAccountDAO;
import com.example.spring.exception.NonExistentUserException;
import com.example.spring.repository.UserAccountRepository;

@Slf4j
@Service
public class UserAccountService {

  @Autowired UserAccountRepository userAccountRepository;

  public UserAccountDAO fillUserAccount(long userId, Integer amount) {

    UserAccountDAO userAccountDAO =
        userAccountRepository.findById(userId).orElseThrow(NonExistentUserException::new);
    Integer newBalance = userAccountDAO.getBalance() + amount;
    userAccountDAO.setBalance(newBalance);
    return userAccountRepository.save(userAccountDAO);
  }

  public UserAccountDAO withdrawMoneyUserAccount(long userId, Integer amount) {

    UserAccountDAO userAccountDAO =
        userAccountRepository.findById(userId).orElseThrow(NonExistentUserException::new);
    Integer newBalance = userAccountDAO.getBalance() - amount;
    userAccountDAO.setBalance(newBalance);
    return userAccountRepository.save(userAccountDAO);
  }
}
