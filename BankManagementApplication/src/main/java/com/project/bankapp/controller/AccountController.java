package com.project.bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bankapp.entity.Account;
import com.project.bankapp.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account savedAccount =  accountService.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
	}
	
	@GetMapping("/{accountNumber}")
	public Account getAccountByAccountNumber(@PathVariable Long accountNumber) {
		return accountService.getAccountDetailsByAccountNumber(accountNumber);
	}
	
	@GetMapping("/allAccounts")
	public List<Account> getAllAccount() {
		return accountService.getAllAccounts();		
	}
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public Account depositAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		return accountService.depositAmount(accountNumber, amount);
	}
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public Account withdrawAmount(@PathVariable Long accountNumber, @PathVariable Double amount) {
		return accountService.withdrawAmount(accountNumber, amount);
	}
	
	@PostMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
		accountService.deleteAccount(accountNumber);
		return ResponseEntity.ok("Account not exist already");
	}
	
	

}
