package com.hiuvek.proyecto.Task.model;

import com.hiuvek.proyecto.Task.exepciones.TaskExcepcion;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    List<Task> tasks = new ArrayList<>();

    public void saveTask(Task task) {

        if (task == null) {
            throw new TaskExcepcion("La tarea no puede ser nula");
        }

        tasks.add(task);
    }


    public Task findById(String id) {

        for (Task task : tasks) {

            if (task.getId().equals(id)) {
                return task;
            }
        }

        return null;
    }


    public void removeTask(String id) {

        Task task = findById(id);

        if (task == null) {
            throw new TaskExcepcion("La tarea no existe");
        }

        tasks.remove(task);
    }


    public void removeTask(Task task) {

        if (!tasks.contains(task)) {
            throw new TaskExcepcion("La tarea no existe en la lista");
        }

        tasks.remove(task);
    }


    public List<Task> findAll() {
        return tasks;
    }


    public int findIndexById(String id) {

        for (int i = 0; i < tasks.size(); i++) {

            if (tasks.get(i).getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }


    public void updateTask(Task updateTask) {

        int index = findIndexById(updateTask.getId());

        if (index == -1) {
            throw new TaskExcepcion("La tarea no existe");
        }

        tasks.set(index, updateTask);
    }
}