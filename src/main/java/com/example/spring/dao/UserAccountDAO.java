package com.example.spring.dao;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_account")
@Entity
public class UserAccountDAO {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  @Column(name = "user_account_id")
  private Long id;

  @OneToOne(fetch = LAZY)
  @MapsId
  @JoinColumn(name = "user_account_id")
  private UserDAO userDAO;

  @Column(name = "balance")
  private Integer balance;
}
