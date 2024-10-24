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

    TaskDto updateTask(UUID taskId, TaskDto taskDto);

    void deleteTask(UUID taskId);
}
