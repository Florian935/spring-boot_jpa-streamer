package com.florian935.jpastreamer.service;

import java.util.List;

public interface CrudService<ENTITY, ID> {

    List<ENTITY> findAll();

    ENTITY findById(ID id);

    ENTITY saveOne(ENTITY entity);

    void deleteById(ID id);

    ENTITY updateOne(ID id, ENTITY entity);
}
