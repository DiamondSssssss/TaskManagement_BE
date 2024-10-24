package com.example.TaskManagement.dto;

import lombok.*;

import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class AccountNoPassDto {
    private UUID AccountId;
    private String Username;
}

