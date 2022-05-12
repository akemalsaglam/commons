package com.aks.commons.graphql;

import com.aks.commons.controller.BaseRequest;
import com.aks.commons.controller.BaseResponse;
import com.aks.commons.jpa.BaseEntity;
import com.aks.commons.jpa.Status;
import com.aks.commons.jpa.auditing.AuditingUtil;
import com.aks.commons.mapper.BaseMapper;
import com.aks.commons.service.BaseService;

import java.util.Optional;

public class BaseGraphQLMutationResolver<Entity extends BaseEntity, Request extends BaseRequest, Response extends BaseResponse, ID>
        implements GraphQLMutationResolver<Request, Response, ID> {

    private final BaseService<Entity, ID> service;
    private final BaseMapper<Entity, Request, Response> mapper;

    public BaseGraphQLMutationResolver(BaseService<Entity, ID> service,
                                       BaseMapper<Entity, Request, Response> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public Optional<Response> update(Request request) {
        Entity entity = mapper.mapRequestToEntity(request);
        AuditingUtil.setUpdateAuditInfo(entity);
        final Entity updatedEntity = service.save(entity);
        return Optional.ofNullable(mapper.mapEntityToResponse(updatedEntity));
    }

    @Override
    public Optional<Response> insert(Request request) {
        Entity entity = mapper.mapRequestToEntity(request);
        AuditingUtil.setCreateAuditInfo(entity);
        final Entity insertedEntity = service.save(entity);
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
            entity.get().setStatus(Status.PASSIVE.toString());
            AuditingUtil.setDeleteAuditInfo(entity.get());
            service.save(entity.get());
        }
    }
}


