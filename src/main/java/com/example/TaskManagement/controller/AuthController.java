package com.example.TaskManagement.controller;

import com.example.TaskManagement.dto.AccountDto;
import com.example.TaskManagement.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public ResponseEntity<AccountDto> register(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(authService.register(accountDto), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<AccountDto> login(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(authService.login(accountDto), HttpStatus.OK);
    }
}
