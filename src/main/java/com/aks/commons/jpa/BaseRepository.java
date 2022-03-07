package com.aks.commons.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T, I> extends CrudRepository<T, I> {

    Optional<T> findById(@NonNull I id);

    List<T> findByName(@NonNull String name);
}
