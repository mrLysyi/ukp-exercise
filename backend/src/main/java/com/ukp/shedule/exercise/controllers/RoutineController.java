package com.ukp.shedule.exercise.controllers;

import com.ukp.shedule.exercise.dao.PnDaynamesDao;
import com.ukp.shedule.exercise.dao.RoutineDao;
import com.ukp.shedule.exercise.dto.RoutineDto;
import com.ukp.shedule.exercise.services.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/routine")
public class RoutineController {



    @Autowired
    private RoutineService routineService;

    @GetMapping("/list")
    public ResponseEntity<List<RoutineDto>> getAllRoutine(){
        List<RoutineDto> respList = routineService.findAll();
        return new ResponseEntity<>(respList, HttpStatus.OK);
    }

}
