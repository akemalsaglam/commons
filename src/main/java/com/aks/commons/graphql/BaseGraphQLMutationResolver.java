package com.aks.commons.graphql;

import com.aks.commons.controller.BaseRequest;
import com.aks.commons.controller.BaseResponse;
import com.aks.commons.jpa.BaseEntity;
import com.aks.commons.jpa.Status;
import com.aks.commons.mapper.BaseMapper;
import com.aks.commons.service.BaseService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public class BaseGraphQLMutationResolver<Entity extends BaseEntity, Request extends BaseRequest, Response extends BaseResponse, ID>
        implements GraphQLMutationResolver<Request, Response, Entity, ID> {

    private final BaseService<Entity, ID> service;
    private final BaseMapper<Entity, Request, Response> mapper;

    public BaseGraphQLMutationResolver(BaseService<Entity, ID> service,
                                       BaseMapper<Entity, Request, Response> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public Optional<Response> insert(Request request) {
        Entity entity = mapper.mapRequestToEntity(request);
        entity.setStatus(Status.ACTIVE.value);
        final Entity insertedEntity = service.save(entity);
        return Optional.ofNullable(mapper.mapEntityToResponse(insertedEntity));
    }

    @Override
    public Entity insertAndReturnEntity(Request request) {
        Entity entity = mapper.mapRequestToEntity(request);
        entity.setStatus(Status.ACTIVE.value);
        return service.save(entity);
    }

    @Override
    public Optional<Response> update(Request request) {
        final Optional<Entity> optionalEntity = service.findById((ID) request.getId());
        if (optionalEntity.isEmpty()) {
            throw new EntityNotFoundException("Item not found by given id.");
        }
        Entity entity = mapper.mapRequestToEntity(request, optionalEntity.get());
        final Entity updatedEntity = service.save(entity);
        return Optional.ofNullable(mapper.mapEntityToResponse(updatedEntity));
    }

    @Override
    public Entity updateAndReturnEntity(Request request) {
        final Optional<Entity> optionalEntity = service.findById((ID) request.getId());
        if (optionalEntity.isEmpty()) {
            throw new EntityNotFoundException("Item not found by given id.");
        }
        Entity entity = mapper.mapRequestToEntity(request);
        return service.save(entity);
    }

    @Override
    public void softDeleteById(ID id) {
        final Optional<Entity> entity = service.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Item not found by given id.");
        }
        entity.get().setStatus(Status.PASSIVE.value);
        service.save(entity.get());
    }

    @Override
    public void deleteById(ID id) {
        final Optional<Entity> entity = service.findById(id);
        if (entity.isEmpty()) {
            throw new EntityNotFoundException("Item not found by given id.");
        }
        service.deleteById(id);
    }

}


