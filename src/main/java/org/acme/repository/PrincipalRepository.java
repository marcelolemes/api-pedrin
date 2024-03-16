package org.acme.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.Dependent;
import org.acme.entity.PersonEntity;

@Dependent
public class PrincipalRepository implements PanacheRepository<PersonEntity> {
}
