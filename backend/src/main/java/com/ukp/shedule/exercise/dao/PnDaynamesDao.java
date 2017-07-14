package com.ukp.shedule.exercise.dao;

import com.ukp.shedule.exercise.domains.PnDaynamesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "pn_daynames", path = "pn_daynames")
public interface PnDaynamesDao extends CrudRepository<PnDaynamesEntity, Short> {

}
