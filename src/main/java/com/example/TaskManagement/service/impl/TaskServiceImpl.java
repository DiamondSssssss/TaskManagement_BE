package com.example.TaskManagement.service.impl;

import com.example.TaskManagement.dto.AccountDto;
import com.example.TaskManagement.dto.AccountNoPassDto;
import com.example.TaskManagement.dto.TaskDto;
import com.example.TaskManagement.entity.Account;
import com.example.TaskManagement.entity.Task;
import com.example.TaskManagement.exception.ResourceNotFoundException;
import com.example.TaskManagement.mapper.AccountMapper;
import com.example.TaskManagement.mapper.TaskMapper;
import com.example.TaskManagement.repository.AccountRepository;
import com.example.TaskManagement.repository.TaskRepository;
import com.example.TaskManagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Account account = accountRepository.findById(taskDto.getAccountId())
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account not found with given Id: " + taskDto.getAccountId()));
        Task task = TaskMapper.toEntity(taskDto,account);
        Task savedTask = taskRepository.save(task);
        return TaskMapper.toDto(savedTask);
    }
    @Override
    public TaskDto getTaskById(UUID taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with given Id: " + taskId));
        return TaskMapper.toDto(task);
    }


    @Override
    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map((task -> TaskMapper.toDto(task)))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto updateTask(UUID taskId, TaskDto updatedTaskDto) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account is not exist with given Id: " + taskId));
        task.setTaskName(updatedTaskDto.getTaskName());
        task.setDescription(updatedTaskDto.getDescription());
        task.setTasktype(updatedTaskDto.getTaskType());
        task.setDeadline(updatedTaskDto.getDeadline());
        task.setStatus(updatedTaskDto.getStatus());

        Task updatedTask = taskRepository.save(task);
        return TaskMapper.toDto(updatedTask);
    }
    public TaskDto updateTaskStatus(UUID taskId, Byte status) {
        // Find the task or throw an exception if not found
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found"));

        // Update the status
        task.setStatus(status);

        // Save the updated task
        Task updatedTask = taskRepository.save(task);

        // Convert the updated Task entity to a TaskDto and return it
        return TaskMapper.toDto(updatedTask);
    }

    @Override
    public List<TaskDto> getTasksByAccountId(UUID accountId) {
        // Find the account to ensure it exists
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with given Id: " + accountId));

        // Fetch tasks associated with the found account
        List<Task> tasks = taskRepository.findByAccountId(account); // Assuming you update this method to find by accountId

        // Convert Task entities to TaskDto
        return tasks.stream()
                .map(TaskMapper::toDto)
                .collect(Collectors.toList());
    }



    @Override
    public void deleteTask(UUID taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Account is not exist with given Id: " + taskId));
        taskRepository.deleteById(taskId);
    }
}
