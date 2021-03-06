package com.ukp.shedule.exercise.dao;

import com.ukp.shedule.exercise.domains.RoutineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "routine", path = "routine")
public interface RoutineDao extends CrudRepository<RoutineEntity, Integer> {
    public Collection<RoutineEntity> findAllById(int id);

}
