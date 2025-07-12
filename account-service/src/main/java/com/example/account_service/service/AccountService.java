package com.example.account_service.service;

import com.example.account_service.model.Account;
import com.example.account_service.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepo accountRepo;

//    @Transactional
    public Account createAccount(Account account) {
        account.setPassword(account.getPassword());
        try{

            var acc=accountRepo.save(account);
        return acc;
        }catch (DataIntegrityViolationException e){
            System.out.println(e);
            throw e;
        }catch (Exception e){
            throw e;
        }


    }


    public Account getAccount(String userId) {
        return accountRepo.findByUserId(userId);
    }

    public List<Account> getAccounts() {
        return accountRepo.findAll();
    }

    public Account updateAccount(String userId, Account account) {
        Account acc=accountRepo.findByUserId(userId);
        String name=account.getName();
        String email=account.getEmail();
        String password=account.getPassword();
        if(name!=null&&!name.isBlank()){
            acc.setName(name);
        }
        if(email!=null&&!email.isBlank()){
            acc.setEmail(email);
        }
        if(password!=null&&!password.isBlank()){
            acc.setPassword(password);
        }
        return accountRepo.save(acc);
    }

    public long deleteAccount(String userId) {
        return accountRepo.deleteByUserId(userId);
    }
}
