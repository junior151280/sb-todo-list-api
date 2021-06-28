package com.example.todolistapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.todolistapi.models.StatusTask;
import com.example.todolistapi.models.Task;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;

@SpringBootTest
public class TaskTest {

    @Test
    void newTask(){
        Task task = CreateTask();
        assertNotNull(task);
    }
    
    @Test
    void getIdTest(){
        Task task = CreateTask();
        assertNotNull(task.getId());
    }

    Task CreateTask(){
        Task task = new Task("785fc372-8f6f-4dfb-af3b-ed7fde28a866","Test",LocalDateTime.now(),StatusTask.PENDING);
        return task;
    } 
}
