package com.example.firebase;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
public class AccountController {
    public AccountService accountService;

    @PostMapping("/create")
    public String createAccount(@RequestBody Account account) throws InterruptedException, ExecutionException{
        return accountService.createAccount(account);
    }
    @GetMapping("/get")
    public Account getAccount(@RequestParam String accountId) throws InterruptedException, ExecutionException{
        return accountService.getAccount(accountId);
    }
    @PutMapping("/update")
    public String updateAccount(@RequestParam  Account account) throws InterruptedException, ExecutionException{
        return accountService.updateAccount(account);
    }
    @PutMapping("/delete")
    public String deleteAccount(@RequestParam String accountId) throws InterruptedException, ExecutionException{
        return accountService.deleteAccount(accountId);
    }
    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint(){
        return ResponseEntity.ok("Test get endPoint is working");
    }
}
