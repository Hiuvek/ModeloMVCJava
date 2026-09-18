package com.hiuvek.proyecto.Task.controller;

import com.hiuvek.proyecto.Task.exepciones.TaskExcepcion;
import com.hiuvek.proyecto.Task.exepciones.TaskValidationExepcion;
import com.hiuvek.proyecto.Task.model.Task;
import com.hiuvek.proyecto.Task.model.TaskRepository;

import java.util.List;

public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String id, String title, String description, Boolean completed) throws TaskValidationExepcion {
        validateTaskData(id,title,description,completed);
        Task task = new Task(id, title, description, completed);
        this.taskRepository.saveTask(task);

        System.out.println("Task agregada exitosamente");
    }

    public void removeTask(String id) {

            this.taskRepository.removeTask(id);

    }
    public void showTask(){
        List<Task> tasks = this.taskRepository.findAll();
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
    public void updateTask(String id, String title, String description, Boolean completed) throws TaskValidationExepcion {
        validateTaskData(id,title,description,completed);
        Task updateTask = new Task(id, title, description, completed);
        this.taskRepository.updateTask(updateTask);
    }
    private void validateTaskData(String id, String title, String description, Boolean completed) throws TaskValidationExepcion {
        if (id == null || id.trim().isEmpty()) {
            throw new TaskValidationExepcion("El id no puede ser vacio");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new TaskValidationExepcion("El titulo no puede ser vacio");

        }
        if (description == null || description.trim().isEmpty()) {
            throw new TaskValidationExepcion("La descripcion no puede ser vacio");

        }
        if (completed == null || completed.booleanValue()) {
            throw new TaskValidationExepcion("El estado no puede ser null");
        }
    }
}