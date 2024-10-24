package com.example.TaskManagement.dto;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class AccountDto {
    private UUID AccountId;
    private String Username;
    private String Password;
}





