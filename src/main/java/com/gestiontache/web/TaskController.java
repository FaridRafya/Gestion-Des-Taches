package com.gestiontache.web;


import com.gestiontache.entities.Task;
import com.gestiontache.service.TaskService;
import org.apache.tomcat.util.http.HeaderUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping("/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task) throws URISyntaxException {
      /*  log.debug("REST request to save Anp : {}", task);
        if ( task.getId() != null) {
            throw new TechnicalError(Error.ENTITY_EXIST_MESSAGE,Error.ENTITY_EXIST,ENTITY_NAME);
        }*/
        Task  result = taskService.save(task);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/task")
    public ResponseEntity<List<Task>> getTask( ) {
       List<Task> page = taskService.findAll();
        return ResponseEntity.ok().body(page);
    }


    @GetMapping(path = "/task/{id}")
    public ResponseEntity<Task> read(@PathVariable Long id) {
        Optional<Task> task= taskService.findOne(id);
        return new ResponseEntity<>(task.get(),HttpStatus.OK);
    }

}
