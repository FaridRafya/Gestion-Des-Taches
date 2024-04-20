package com.gestiontache.service;

import com.gestiontache.entities.Projet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProjetService {

    Projet save(Projet projet) ;

    Projet update(Projet projet) throws Exception;


    List<Projet> findAll( ) ;

    /**
     * Get the "id" Projet.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Projet> findOne(Long id)throws Error;
    void delete(Long id);

}
