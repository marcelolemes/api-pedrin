package org.acme.service;

import jakarta.enterprise.context.Dependent;
import org.acme.entity.PersonEntity;
import org.acme.repository.PrincipalRepository;

import java.util.List;

@Dependent
public class PrincipalService {
    private PrincipalRepository repository;

    public PrincipalService(PrincipalRepository repository) {
        this.repository = repository;
    }

    public void create(PersonEntity entity) {
        repository.persist(entity);
    }

    public void update(PersonEntity entity) {
        repository.persist(entity);
    }

    public List<? extends PersonEntity> fetchAll() {
        return repository.findAll().stream().toList();
    }
    public void delete(PersonEntity entity) {
        repository.delete(entity);
    }
    public PersonEntity fetchById(Long id) {
        return repository.findById(id);
    }
}
