package com.gestiontache.service;

import com.gestiontache.entities.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TaskService {


    Task save(Task task) ;

    Task update(Task task) throws Exception;


    Page<Task> findAll(Pageable pageable) ;

    /**
     * Get the "id" Task.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Task> findOne(Long id)throws Error;
    void delete(Long id);

}
