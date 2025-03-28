package com.project.bankapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bankapp.entity.Account;
import com.project.bankapp.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public Account createAccount(Account account) {
		Account savedAccount = accountRepository.save(account);
		return savedAccount;
	}

	@Override
	public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		Optional<Account> optional = accountRepository.findById(accountNumber);
		if(optional.isEmpty()) {
			throw new RuntimeException("Account is not present");
		}
		
		Account account = optional.get();
		return account;
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> listAccount = accountRepository.findAll();
		return listAccount;
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		Optional<Account> optional = accountRepository.findById(accountNumber);
		if(optional.isEmpty()) {
			throw new RuntimeException("There is no such account");
		}		
		Account account = optional.get();
		Double result = account.getAccountBalance() + amount;
		account.setAccountBalance(result);
		accountRepository.save(account);
		return account;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		Optional<Account> optional = accountRepository.findById(accountNumber);
		if(optional.isEmpty()) {
			throw new RuntimeException("There is no such account");
		}		
		Account account = optional.get();
		Double result = account.getAccountBalance() - amount;
		account.setAccountBalance(result);
		accountRepository.save(account);
		return account;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAccount(Long accountNumber) {
		accountRepository.deleteById(accountNumber);
		
	}
	
	

}
