package com.florian935.jpastreamer.dto;

import com.florian935.jpastreamer.domain.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class PetDto {

    Integer petId;
    String name;

    public PetDto(Pet pet) {
        this.petId = pet.getPetId();
        this.name = pet.getName();
    }
}
