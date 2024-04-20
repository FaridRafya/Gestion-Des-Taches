package com.gestiontache.web;


import com.gestiontache.entities.Projet;
import com.gestiontache.service.ProjetService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjetController {


    private ProjetService projetService;

    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @PostMapping("/projet")
    public ResponseEntity<Projet>  createProjet(@RequestBody Projet projet){

        Projet projet1 = projetService.save(projet);

        return new   ResponseEntity<>(projet1 , HttpStatus.OK);
    }

    @GetMapping("/projet")
    public  ResponseEntity<List<Projet>> getProjet(){
        List<Projet> projets=  projetService.findAll();
        return  ResponseEntity.ok().body(projets);
    }

}
