package com.example.account_service.repo;

import com.example.account_service.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository
public interface AccountRepo extends JpaRepository<Account,Long> {
    Optional<Account> findByEmail(String email);
    Optional<Account> findTopByOrderByUserIdDesc();

    Account findByUserId(String userId);

    @Transactional
    long deleteByUserId(String userId);
}
