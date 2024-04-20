package com.gestiontache.service.impl;

import com.gestiontache.entities.Task;
import com.gestiontache.repositories.TaskRepository;
import com.gestiontache.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceimpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceimpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task) {
        task = taskRepository.save(task);
        return task;
    }

    @Override
    public Task update(Task task) throws Exception {
        if (!taskRepository.existsById(task.getId())) {
            throw new Exception("entity not found");
        }
        task = taskRepository.save(task);
        return task;
    }


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> findOne(Long id) throws Error {
        return taskRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
    taskRepository.deleteById(id);
    }
}
