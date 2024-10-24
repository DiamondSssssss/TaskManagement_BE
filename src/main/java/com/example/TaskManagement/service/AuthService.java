package com.example.TaskManagement.service;

import com.example.TaskManagement.dto.AccountDto;

public interface AuthService {
    AccountDto register(AccountDto accountDto);
    AccountDto login(AccountDto accountDto);
}
