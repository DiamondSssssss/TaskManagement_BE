package com.example.TaskManagement.repository;

import com.example.TaskManagement.entity.Account;
import com.example.TaskManagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByAccountId(Account account);
}
