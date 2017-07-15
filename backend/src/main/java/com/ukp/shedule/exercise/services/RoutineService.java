package com.ukp.shedule.exercise.services;


import com.ukp.shedule.exercise.dao.PnDaynamesDao;
import com.ukp.shedule.exercise.dao.RoutineDao;
import com.ukp.shedule.exercise.domains.RoutineEntity;
import com.ukp.shedule.exercise.dto.RoutineDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

@Service
public class RoutineService {

    @Autowired
    private RoutineDao routineDao;

    @Autowired
    private PnDaynamesDao pnDaynamesDao;

    /**
     * @param id - routine id (not distinct)
     * @return list of all dto entities, sorted by pn_daynames.orderby
     */
    public List<RoutineDto> findAllById(int id) {
        List<RoutineEntity> entityList = null;
        List<RoutineDto> dtoList = null;
        try {
            entityList = (List<RoutineEntity>) routineDao.findAllById(id);
        } catch (Exception e) {
            //log
        }
        dtoList = entityList.stream()
                .map(routineEntity -> new RoutineDto(routineEntity))
                .sorted(Comparator.comparingInt(p -> p.getPnDaynamesByDayofweek().getOrderby()))
                .collect(Collectors.toList());
        return dtoList;
    }

    /**
     * @return list of all dto entities
     */
    public List<RoutineDto> findAll() {
        List<RoutineEntity> entityList = null;
        List<RoutineDto> dtoList = null;
        try {
            entityList = (List<RoutineEntity>) routineDao.findAll();
        } catch (Exception e) {
            //log
        }
        dtoList = entityList.stream()
                .map(routineEntity -> new RoutineDto(routineEntity))
                .sorted(Comparator.comparingInt(p -> p.getIdOrigin()))
                .collect(Collectors.toList());
        return dtoList;
    }


    // Routine ent -> to Dto SET, without duplicates
    // sort by dayofweek
    // form

    /**
     * @param id - routine id (not distinct)
     * @return clean routine schedule, days are united
     */

    public List<RoutineDto> findAllByIdUnitedShedule(int id) {
        List<RoutineDto> dtoList = findAllById(id);

        if (dtoList.size() > 1) {

            final ListIterator<RoutineDto> iter = dtoList.listIterator();
            RoutineDto next = iter.next();
            RoutineDto baseNode = next; //node for "appending"  setPnDaynamesPeriodTo
            RoutineDto prev = next;
            while (iter.hasNext()) {
                next = iter.next();
                if (!prev.equals(next)) {
                    System.out.println("--- operation " + "next: " + next.getIdOrigin() + "prev: " + prev.getIdOrigin());
                    System.out.println("prev");
                    System.out.println(prev.getIdOrigin());
                    if (prev.equalsForUnio(next)) {
                        baseNode.setPnDaynamesPeriodTo(next.getPnDaynamesByDayofweek());  // base node setPnDaynamesPeriodTo
                        iter.remove();
                        System.out.println("rem:------------------" + next.getIdOrigin());
                    }
                    System.out.println("next");
                    System.out.println(next.getIdOrigin());
                } else { // set new base node
                    baseNode = next; // reset base node
                }
                prev = next;
            }
        }


        return dtoList;
    }
}
