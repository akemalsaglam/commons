package com.aks.commons.graphql;

import com.aks.commons.controller.BaseRequest;
import com.aks.commons.controller.BaseResponse;
import com.aks.commons.jpa.BaseEntity;
import com.aks.commons.mapper.BaseMapper;
import com.aks.commons.service.BaseService;

import java.util.List;
import java.util.Optional;

public class BaseGraphQLQueryResolver<Entity extends BaseEntity, Request extends BaseRequest, Response extends BaseResponse, ID>
        implements GraphQLQueryResolver<Response, ID> {

    private final BaseService<Entity, ID> service;
    private final BaseMapper<Entity, Request, Response> mapper;

    public BaseGraphQLQueryResolver(BaseService<Entity, ID> service,
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
    public List<Response> getAllActive() {
        return mapper.mapEntityListToResponseList(service.findAllActive());
    }

    @Override
    public Optional<Response> getActiveById(ID id) {
        final Optional<Entity> eventEntity = service.findActiveById(id);
        return eventEntity.map(mapper::mapEntityToResponse);
    }
}


