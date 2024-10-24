package com.example.TaskManagement.mapper;

import com.example.TaskManagement.dto.AccountDto;
import com.example.TaskManagement.dto.AccountNoPassDto;
import com.example.TaskManagement.entity.Account;

public class AccountMapper {
    public static AccountDto toDto(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountDto(
                account.getAccountId(),
                account.getUsername(),
                account.getPassword()

        );
    }

    public static Account toEntity(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        }
        Account account = new Account();
        account.setAccountId(accountDto.getAccountId());
        account.setUsername(accountDto.getUsername());
        account.setPassword(accountDto.getPassword());
        return account;
    }

    public static AccountNoPassDto toNoPassDto(Account account) {
        if (account == null) {
            return null;
        }
        return new AccountNoPassDto(
                account.getAccountId(),
                account.getUsername()
        );
    }
}
