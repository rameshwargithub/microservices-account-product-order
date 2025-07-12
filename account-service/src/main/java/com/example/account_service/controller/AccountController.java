package com.example.account_service.controller;

import com.example.account_service.service.AccountService;
import com.example.account_service.model.Account;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("account-apis")
@CrossOrigin
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("account")
    public ResponseEntity<?> signup(@Valid @RequestBody Account account){
        return ResponseEntity.status(201).body(accountService.createAccount(account));
    }
    @GetMapping("account")
    public ResponseEntity<List<Account>> getAccounts(){
        return ResponseEntity.status(200).body(accountService.getAccounts());
    }
    @GetMapping("account/{userId}")
    public ResponseEntity<?> getAccount(@PathVariable String userId){
        Account account=accountService.getAccount(userId);
        return ResponseEntity.status(account==null?204:200).body(account);
    }
    @PatchMapping("account/{userId}")
    public ResponseEntity<Account> getUserData(@PathVariable String userId,@RequestBody Account account){
        Account acc=accountService.updateAccount(userId,account);
        return ResponseEntity.status(acc==null?204:200).body(acc);
    }

    @DeleteMapping("account/{userId}")
    public ResponseEntity<?> getUserData(@PathVariable String userId){
        long accountId=accountService.deleteAccount(userId);
        return ResponseEntity.status(accountId==0?204:200).body(accountId);
    }

}
