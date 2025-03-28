package com.project.bankapp.service;

import java.util.List;

import com.project.bankapp.entity.Account;

public interface AccountService {
	
	public Account createAccount(Account account);
	
	public Account getAccountDetailsByAccountNumber(Long accountNumber);
	
	public List<Account> getAllAccounts();
	
	public Account depositAmount(Long accountNumber, Double amount);
	
	public Account withdrawAmount(Long accountNumber, Double amount);
	
	public void closeAccount(Long accountNumber);
	
	
	
	public void deleteAccount(Long accountNumber);

}
