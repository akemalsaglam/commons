package com.aks.commons.controller;

import com.aks.commons.jpa.BaseEntity;
import com.aks.commons.jpa.Status;
import com.aks.commons.mapper.BaseMapper;
import com.aks.commons.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AbstractController<Entity extends BaseEntity, Request extends BaseRequest, Response extends BaseResponse, ID>
        implements BaseController<Request, Response, ID> {

    private final BaseService<Entity, ID> service;
    private final BaseMapper<Entity, Request, Response> mapper;

    public AbstractController(BaseService<Entity, ID> service,
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
            entity.get().setStatus(Status.PASSIVE.toString());
            service.save(entity.get());
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}


