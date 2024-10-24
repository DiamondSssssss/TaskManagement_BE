package com.example.TaskManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Task")
@Data
@Builder

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "TaskId")
    private UUID taskId;

    @Column(name = "TaskName", nullable = false, unique = true)
    private String taskName;

    @Column(name = "TaskType",nullable = false)
    private Byte tasktype;

    @Column(name = "Description")
    private String description;
    @Column(name = "Deadline")
    private LocalDateTime deadline;
    @Column(name = "Status")
    private Byte status;

    @ManyToOne
    @JoinColumn(name = "accountId", nullable = false)
    private Account accountId;

}
