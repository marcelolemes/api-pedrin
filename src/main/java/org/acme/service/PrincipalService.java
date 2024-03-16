package org.acme.service;

import jakarta.enterprise.context.Dependent;
import org.acme.controller.PersonDTO;
import org.acme.entity.PersonEntity;
import org.acme.repository.PrincipalRepository;
import org.acme.util.PersonMapper;

import java.util.List;
import java.util.Objects;

@Dependent
public class PrincipalService {
    private PrincipalRepository repository;

    public PrincipalService(PrincipalRepository repository) {
        this.repository = repository;
    }

    public void create(PersonEntity entity) {
        repository.persist(entity);
    }

    public void update(Long id, PersonEntity newEntity) {
        final PersonEntity entity = repository.findById(id);
        PersonMapper.updateEntity(entity, newEntity);
        repository.persist(entity);
    }

    public List<? extends PersonEntity> fetchAll() {
        return repository.findAll().stream().toList();
    }

    public void delete(Long id) {
        final PersonEntity entity = repository.findById(id);
        if (Objects.nonNull(entity)) {
            repository.delete(entity);
        }
    }

    public PersonEntity fetchById(Long id) {
        return repository.findById(id);
    }
}
