package com.aks.commons.graphql;

import com.aks.commons.controller.BaseController;
import com.aks.commons.controller.BaseRequest;
import com.aks.commons.controller.BaseResponse;
import com.aks.commons.jpa.BaseEntity;
import com.aks.commons.jpa.Status;
import com.aks.commons.mapper.BaseMapper;
import com.aks.commons.service.BaseService;

import java.util.List;
import java.util.Optional;

public class BaseGraphQLMutationResolver<Entity extends BaseEntity, Request extends BaseRequest, Response extends BaseResponse, ID>
        implements BaseController<Request, Response, ID> {

    private final BaseService<Entity, ID> service;
    private final BaseMapper<Entity, Request, Response> mapper;

    public BaseGraphQLMutationResolver(BaseService<Entity, ID> service,
                                       BaseMapper<Entity, Request, Response> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public Optional<Response> getById(ID id) {
        final Optional<Entity> eventEntity = service.findById(id);
        return eventEntity.map(mapper::mapEntityToResponse);
    }

    @Override
    public List<Response> getAll() {
        return mapper.mapEntityListToResponseList(service.findAll());
    }

    @Override
    public Optional<Response> update(Request request) {
        Entity entity = mapper.mapRequestToEntity(request);
        final Entity updatedEntity = service.save(entity);
        return Optional.ofNullable(mapper.mapEntityToResponse(updatedEntity));
    }

    @Override
    public Optional<Response> insert(Request eventRequest) {
        Entity eventEntity = mapper.mapRequestToEntity(eventRequest);
        final Entity insertedEntity = service.save(eventEntity);
        return Optional.ofNullable(mapper.mapEntityToResponse(insertedEntity));
    }

    @Override
    public void deleteById(ID id) {
        service.deleteById(id);
    }

    @Override
    public void softDeleteById(ID id) {
        final Optional<Entity> entity = service.findById(id);
        if (entity.isPresent()) {
            entity.get().setStatus(Status.PASSIVE);
            service.save(entity.get());
        }
    }
}


