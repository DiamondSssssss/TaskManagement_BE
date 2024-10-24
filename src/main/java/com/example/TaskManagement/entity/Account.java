package com.example.TaskManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Account")
@Data
@Builder

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "AccountId")
    private UUID accountId;

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @Column(name = "Password",nullable = false)
    private String password;

}
