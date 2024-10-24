package com.example.TaskManagement.controller;

import com.example.TaskManagement.dto.TaskDto;
import com.example.TaskManagement.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") UUID taskId) {
        TaskDto taskDto = taskService.getTaskById(taskId);
        return ResponseEntity.ok(taskDto);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        List<TaskDto> taskDtos = taskService.getAllTasks();
        return ResponseEntity.ok(taskDtos);
    }

    @GetMapping("/account/{accountId}") // New endpoint to get tasks by account ID
    public ResponseEntity<List<TaskDto>> getTasksByAccountId(@PathVariable("accountId") UUID accountId) {
        List<TaskDto> taskDtos = taskService.getTasksByAccountId(accountId);
        return ResponseEntity.ok(taskDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto,
                                              @PathVariable("id") UUID taskId) {
        return ResponseEntity.ok(taskService.updateTask(taskId, taskDto));
    }

    @PutMapping("{id}/status")
    public ResponseEntity<TaskDto> updateTaskStatus(@PathVariable("id") UUID taskId, @RequestBody Byte status) {
        // Call the service to update the status
        TaskDto updatedTask = taskService.updateTaskStatus(taskId, status);

        // Return the updated TaskDto
        return ResponseEntity.ok(updatedTask);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") UUID taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
