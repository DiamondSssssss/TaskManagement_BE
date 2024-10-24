package com.example.TaskManagement.service;

import com.example.TaskManagement.dto.AccountDto;
import com.example.TaskManagement.dto.AccountNoPassDto;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountNoPassDto getAccountById(UUID accountId);

    List<AccountDto> getAllAccounts();

    AccountDto updateAccount(UUID accountId, AccountDto accountDto);

    void deleteAccount(UUID accountId);
}
