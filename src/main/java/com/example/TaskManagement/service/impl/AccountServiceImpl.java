package com.example.TaskManagement.service.impl;

import com.example.TaskManagement.dto.AccountDto;
import com.example.TaskManagement.dto.AccountNoPassDto;
import com.example.TaskManagement.entity.Account;
import com.example.TaskManagement.exception.ResourceNotFoundException;
import com.example.TaskManagement.mapper.AccountMapper;
import com.example.TaskManagement.repository.AccountRepository;
import com.example.TaskManagement.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.toEntity(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.toDto(savedAccount);
    }

    public AccountNoPassDto getAccountById(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found " + accountId));
        return AccountMapper.toNoPassDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map((account -> AccountMapper.toDto(account)))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto updateAccount(UUID accountId, AccountDto updatedAccountDto) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account is not exist with given Id: " + accountId));

        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.toDto(updatedAccount);
    }

    @Override
    public void deleteAccount(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account is not exist with given Id: " + accountId));
        accountRepository.deleteById(accountId);
    }
}
