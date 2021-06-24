package com.example.todolistapi.controllers;

import java.time.LocalDateTime;

import com.example.todolistapi.models.StatusTask;
import com.example.todolistapi.models.Task;
import com.example.todolistapi.repositories.TaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  @Autowired
  TaskRepository taskRepository;

  @RequestMapping(method = RequestMethod.POST, value = "/tasks")
  public String create(@RequestBody Task task) {
    if (task.getStatus() == null) {
      task.setStatus(StatusTask.PENDING);
    }
    if (task.getDate() == null) {
      task.setDate(LocalDateTime.now());
    }
    taskRepository.save(task);
    return task.getId();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/tasks")
  public Iterable<Task> list() {
    return taskRepository.findAll();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/tasks/{id}")
  public Task show(@PathVariable String id) {
    return taskRepository.findById(id).get();
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/tasks/{id}")
  public Task update(@PathVariable String id, @RequestBody Task task) {
    Task taskToUpd = taskRepository.findById(id).get();
    if (task.getName() != null) {
      taskToUpd.setName(task.getName());
    }
    if (task.getStatus() != null) {
      taskToUpd.setStatus(task.getStatus());
    }
    taskRepository.save(taskToUpd);
    return taskToUpd;
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/tasks/{id}")
  public String delete(@PathVariable String id) {
    Task task = taskRepository.findById(id).get();
    taskRepository.delete(task);
    return "Product Deleted";
  }
}