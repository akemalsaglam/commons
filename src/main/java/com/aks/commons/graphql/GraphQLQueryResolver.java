package com.aks.commons.graphql;

import com.aks.commons.controller.BaseResponse;
import com.aks.commons.jpa.BaseEntity;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface GraphQLQueryResolver<Response extends BaseResponse, Entity extends BaseEntity, ID> {

    Optional<Response> getById(@Valid ID id);
    Optional<Response> getActiveById(@Valid ID id);
    List<Response> getAll();
    List<Response> getAllActive();

    Optional<Entity> getEntityById(@Valid ID id);
    Optional<Entity> getActiveEntityById(@Valid ID id);
    List<Entity> getAllEntities();
    List<Entity> getAllActiveEntities();


}


