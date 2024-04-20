package com.gestiontache.service.impl;

import com.gestiontache.entities.Projet;
import com.gestiontache.repositories.ProjetRepository;
import com.gestiontache.service.ProjetService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetServiceImpl implements ProjetService {


    private  final ProjetRepository projetRepository;


    public ProjetServiceImpl(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Override
    public Projet save(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public Projet update(Projet projet) throws Exception {
        return projetRepository.save(projet);
    }

    @Override
    public List<Projet> findAll( ) {
        return projetRepository.findAll();
    }

    @Override
    public Optional<Projet> findOne(Long id) throws Error {
        return projetRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
    projetRepository.deleteById(id);
    }
}
