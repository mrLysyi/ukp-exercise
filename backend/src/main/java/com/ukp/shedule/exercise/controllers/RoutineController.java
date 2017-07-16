package com.ukp.shedule.exercise.controllers;

import com.ukp.shedule.exercise.dao.PnDaynamesDao;
import com.ukp.shedule.exercise.dao.RoutineDao;
import com.ukp.shedule.exercise.dto.RoutineDto;
import com.ukp.shedule.exercise.dto.RoutineListsDto;
import com.ukp.shedule.exercise.services.RoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routine")
public class RoutineController {



    @Autowired
    private RoutineService routineService;

    /**
     *
     * @return all dto ent
     */
    @GetMapping("/list")
    public ResponseEntity<List<RoutineDto>> getAllRoutine(){
        List<RoutineDto> respList = routineService.findAll();
        return new ResponseEntity<>(respList, HttpStatus.OK);
    }

    /**
     *
     * @return  dto entities by Id
     */
    @GetMapping("/rawlist/{id}")
    public ResponseEntity<List<RoutineDto>> getAllRoutineById(@PathVariable("id") int id){
        List<RoutineDto> respList = routineService.findAllById(id);
        if (respList.size() == 0)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        routineService.findAllByIdUnitedShedule(id); //TEST
        return new ResponseEntity<>(respList, HttpStatus.OK);
    }

    /**
     *
     * @return  dto entities by Id
     */
    @GetMapping("/unitedlist/{id}")
    public ResponseEntity<List<RoutineDto>> getAllRoutineByIdUnited(@PathVariable("id") int id){
        List<RoutineDto> respList = routineService.findAllByIdUnitedShedule(id);
        if (respList.size() == 0)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(respList, HttpStatus.OK);
    }



    @GetMapping("/unitedlist/all")
    public ResponseEntity<RoutineListsDto> getAllRoutineUnited(){
        RoutineListsDto resp = routineService.findAlldUnitedShedule();
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }


}
