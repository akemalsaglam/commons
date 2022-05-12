package com.aks.commons.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public class BaseDomainService<E, Id> implements BaseService<E, Id> {

    private final JpaRepository<E, Id> repository;

    public BaseDomainService(JpaRepository<E, Id> repository) {
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

    @SuppressWarnings("unchecked")
    @Override
    public Optional<E> findById(Id id) {
        return repository.findById(id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void deleteById(Id id) {
        repository.deleteById(id);
    }
}
