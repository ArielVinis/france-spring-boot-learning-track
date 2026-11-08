package com.taskmanager.application;

import com.taskmanager.application.output.TaskOutput;
import com.taskmanager.domain.TaskId;
import com.taskmanager.domain.TaskNotFoundException;
import com.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id).map(TaskOutput::from).orElseThrow(() -> new TaskNotFoundException(id));
    }
}
