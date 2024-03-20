package org.acme.service;

import org.acme.entity.PersonEntity;
import org.acme.repository.PrincipalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class PrincipalServiceTest {
    private PrincipalService service;

    @BeforeEach
    void loadService() {
        var repository = Mockito.mock(PrincipalRepository.class);
        service = new PrincipalService(repository);
    }

    @Test
    void create() {
        var entity = new PersonEntity();
        Assertions.assertDoesNotThrow(()-> service.create(entity));
    }

    @Test
    void delete() {
        Assertions.assertDoesNotThrow(()-> service.delete(1L));
    }

}