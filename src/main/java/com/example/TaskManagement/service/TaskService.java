package com.example.TaskManagement.service;

import com.example.TaskManagement.dto.AccountDto;
import com.example.TaskManagement.dto.AccountNoPassDto;
import com.example.TaskManagement.dto.TaskDto;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    TaskDto createTask(TaskDto taskDto);

    TaskDto getTaskById(UUID id);
    List<TaskDto> getAllTasks();

    List<TaskDto> getTasksByAccountId(UUID accountId);

    TaskDto updateTask(UUID taskId, TaskDto taskDto);

    TaskDto updateTaskStatus(UUID taskId, Byte status);
    void deleteTask(UUID taskId);
}
