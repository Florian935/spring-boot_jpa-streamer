package com.florian935.jpastreamer.controller;

import com.florian935.jpastreamer.domain.Pet;
import com.florian935.jpastreamer.service.PetService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1.0/pets")
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PetController {

    PetService petService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(OK)
    List<Pet> getAllPets() {

        return petService.findAll();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(CREATED)
    Pet savePet(@RequestBody Pet pet) {

        return petService.saveOne(pet);
    }
}
