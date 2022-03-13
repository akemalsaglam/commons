package com.aks.commons.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<Entity, ID> {

    Entity save(Entity entity);

    Entity saveAndFlush(Entity entity);

    List<Entity> findAll();

    Optional<Entity> findById(ID id);

    void deleteById(ID id);

}
