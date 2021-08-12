package com.florian935.jpastreamer.service.implementation;

import com.florian935.jpastreamer.domain.Pet;
import com.florian935.jpastreamer.repository.PetRepository;
import com.florian935.jpastreamer.service.PetService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class PetServiceImpl implements PetService {

    PetRepository petRepository;

    @Override
    public List<Pet> findAll() {

        return petRepository.findAll();
    }

    @Override
    public Pet findById(Integer integer) {

        return null;
    }

    @Override
    public Pet saveOne(Pet pet) {

        return petRepository.save(pet);
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public Pet updateOne(Integer integer, Pet pet) {

        return null;
    }
}
