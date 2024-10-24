package com.example.TaskManagement.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.TaskManagement.dto.AccountDto;
import com.example.TaskManagement.entity.Account;
import com.example.TaskManagement.mapper.AccountMapper;
import com.example.TaskManagement.repository.AccountRepository;
import com.example.TaskManagement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public AccountDto register(AccountDto accountDto) {
        Account account= AccountMapper.toEntity(accountDto);
        account.setPassword(BCrypt.withDefaults().hashToString(12, account.getPassword().toCharArray()));
        Account registeredaccount=  accountRepository.save(account);
        return AccountMapper.toDto(registeredaccount);
    }

    @Override
    public AccountDto login(AccountDto accountDto) {
        Account account = accountRepository.findByUsername(accountDto.getUsername());
        if(account!=null){
            if(BCrypt.verifyer().verify(accountDto.getPassword().toCharArray(), account.getPassword()).verified){
                return AccountMapper.toDto(account);
            }
        }
        return null;
    }
}
