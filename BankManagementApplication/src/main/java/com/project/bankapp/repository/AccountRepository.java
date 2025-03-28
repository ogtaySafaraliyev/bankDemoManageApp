package com.project.bankapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bankapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
	

}
