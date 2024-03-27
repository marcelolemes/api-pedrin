package org.acme.util;

import org.acme.controller.PersonDTO;
import org.acme.entity.PersonEntity;

public final class PersonMapper {
    public static PersonDTO toDTO(PersonEntity entity) {
        return new PersonDTO(entity.getName(), entity.getBirth());
    }

    public static PersonEntity toEntity(PersonDTO dto) {
        return new PersonEntity(dto.name(), dto.birth());
    }

    public static void updateEntity(PersonEntity firstEntity, PersonEntity newEntity) {
        firstEntity.setBirth(newEntity.getBirth());
        firstEntity.setName(newEntity.getName());
    }

}
