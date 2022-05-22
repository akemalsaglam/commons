package com.aks.commons.service;

import com.aks.commons.jpa.BaseEntity;
import com.aks.commons.jpa.BaseRepository;
import com.aks.commons.jpa.Status;

import java.util.List;
import java.util.Optional;


public class BaseDomainService<E extends BaseEntity, Id> implements BaseService<E, Id> {

    private final BaseRepository<E, Id> repository;

    public BaseDomainService(BaseRepository<E, Id> repository) {
        this.repository = repository;
    }


    @SuppressWarnings("unchecked")
    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public E saveAndFlush(E entity) {
        return repository.saveAndFlush(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public List<E> findAllActive() {
        return repository.findByStatusIs(Status.ACTIVE.value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<E> findById(Id id) {
        return repository.findById(id);
    }

    @Override
    public Optional<E> findActiveById(Id id) {
        return repository.findByIdIsAndStatusIs(id, Status.ACTIVE.value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void deleteById(Id id) {
        repository.deleteById(id);
    }
}
