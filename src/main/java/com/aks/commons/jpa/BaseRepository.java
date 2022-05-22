package com.aks.commons.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<Entity extends BaseEntity, ID> extends JpaRepository<Entity, ID> {

    List<Entity> findByStatusIs(String status);

    Entity findByIdIsAndStatusIs(ID id, String status);
}
