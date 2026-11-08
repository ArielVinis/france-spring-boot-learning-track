package com.taskmanager.infrastructure.repository;


import com.taskmanager.domain.TaskRepository;
import com.taskmanager.domain.TaskRepositoryTest;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {
    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}
