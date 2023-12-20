package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.entity.Task;
import com.example.backend.repository.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public void createTask(Task task){
        taskRepository.insert(task);
    }
}