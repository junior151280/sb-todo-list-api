package com.example.todolistapi.repositories;

import com.example.todolistapi.models.Task;

import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {
}