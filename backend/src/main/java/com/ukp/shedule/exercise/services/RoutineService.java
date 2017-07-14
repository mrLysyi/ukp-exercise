package com.ukp.shedule.exercise.services;


import com.ukp.shedule.exercise.dao.PnDaynamesDao;
import com.ukp.shedule.exercise.dao.RoutineDao;
import com.ukp.shedule.exercise.domains.RoutineEntity;
import com.ukp.shedule.exercise.dto.RoutineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoutineService {

    @Autowired
    private RoutineDao routineDao;

    @Autowired
    private PnDaynamesDao pnDaynamesDao;

    /**
     *
     * @return list of all dto entities
     */
    public List<RoutineDto> findAll(){
        List<RoutineEntity> entityList = null;
        List<RoutineDto> dtoList = null;
        try{
            entityList = (List<RoutineEntity>) routineDao.findAll();
        }catch (Exception e){
            //log
        }
        dtoList = entityList.stream()
                .map(routineEntity -> new RoutineDto(routineEntity))
                .collect(Collectors.toList());
        return dtoList;
    }
}
