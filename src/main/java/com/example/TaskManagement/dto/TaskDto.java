package com.example.TaskManagement.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TaskDto {
    private UUID TaskId;
    private UUID AccountId;
    private String TaskName;
    private Byte TaskType;
    private String Description;
    private LocalDateTime Deadline;
    private Byte Status;
}