package org.acme.util;

import org.acme.controller.PersonDTO;
import org.acme.entity.PersonEntity;

public final class PersonMapper {
    public static PersonDTO toDTO(PersonEntity entity){
        return new PersonDTO(entity.getId(), entity.getName(), entity.getBirth());
    }
    public static PersonEntity toEntity(PersonDTO dto){
        return new PersonEntity(dto.getId(), dto.getName(), dto.getBirth());
    }
}
