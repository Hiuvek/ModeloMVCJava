package com.hiuvek.proyecto.Task.controller;

import com.hiuvek.proyecto.Task.model.Task;
import com.hiuvek.proyecto.Task.model.TaskRepository;

import java.util.List;

public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String id, String title, String description, Boolean completed) {
        Task task = new Task(id, title, description, completed);
        this.taskRepository.saveTask(task);

        System.out.println("Task agregada exitosamente");
    }

    public void removeTask(String id) {
        try {
            this.taskRepository.removeTask(id);
        } catch (Exception e) {
            System.out.println("Error al eliminar el task");
        }

    }
    public void showTask(){
        List<Task> tasks = this.taskRepository.findAll();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
    public void updateTask(String id, String title, String description, Boolean completed) {
        Task updateTask = new Task(id, title, description, completed);
        this.taskRepository.updateTask(updateTask);
    }
}