package com.gungalla.springresttask.service;

import com.gungalla.springresttask.domain.task.Task;

import java.util.List;

public interface TaskService {

    Task getById(Long id);

    List<Task> getAllByUserId(Long id);

    Task update(Task task);

    Task create(Task task, Long id);

    void delete(Long id);

}
