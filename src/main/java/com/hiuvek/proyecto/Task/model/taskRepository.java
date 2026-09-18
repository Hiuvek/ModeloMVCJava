package com.hiuvek.proyecto.Task.model;

import com.hiuvek.proyecto.Task.controller.Task;

import java.util.ArrayList;
import java.util.List;

public class taskRepository {
    List<Task> tasks = new ArrayList<>();
    public void saveTask(Task task) {
        tasks.add(task);
    }
    public Task findById(int id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }
    public void removeTask(int id) {
        Task task = findById(id);
        tasks.remove(task);
    }
    public List<Task> findAll() {
        return tasks;
    }
    public int findIndexById(int id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

}
