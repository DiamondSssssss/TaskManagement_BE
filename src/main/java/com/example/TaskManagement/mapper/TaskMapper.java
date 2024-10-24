package com.example.TaskManagement.mapper;

import com.example.TaskManagement.dto.TaskDto;
import com.example.TaskManagement.entity.Account;
import com.example.TaskManagement.entity.Task;


public class TaskMapper {
    public static TaskDto toDto(Task task) {
        if(task == null) {
            return null;
        }
        return new TaskDto(
            task.getTaskId(),
            task.getAccountId().getAccountId(),
            task.getTaskName(),
            task.getTasktype(),
            task.getDescription(),
            task.getDeadline(),
            task.getStatus()
        );
    }
    public static Task toEntity(TaskDto taskDto, Account account) {
        if(taskDto == null) {
            return null;
        }
        Task task = new Task();
        task.setTaskId(taskDto.getTaskId());
        task.setAccountId(account);
        task.setTaskName(taskDto.getTaskName());
        task.setTasktype(taskDto.getTaskType());
        task.setDescription(taskDto.getDescription());
        task.setDeadline(taskDto.getDeadline());
        task.setStatus(taskDto.getStatus());

        return task;
    }
}