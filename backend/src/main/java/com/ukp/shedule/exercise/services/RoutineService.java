package com.ukp.shedule.exercise.services;


import com.ukp.shedule.exercise.dao.PnDaynamesDao;
import com.ukp.shedule.exercise.dao.RoutineDao;
import com.ukp.shedule.exercise.domains.RoutineEntity;
import com.ukp.shedule.exercise.dto.RoutineDto;
import com.ukp.shedule.exercise.dto.RoutineListsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTMLDocument;
import java.util.*;
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
                .sorted(Comparator.comparingInt(p -> p.getId())) //.sorted(Comparator.comparingInt(p -> p.getPnDaynamesByDayofweek().getOrderby()))

                .collect(Collectors.toList());
        return dtoList;
    }


    // Routine ent -> to Dto SET, without duplicates
    // sort by dayofweek


    /**
     * @param id - routine id (not distinct)
     * @return clean routine schedule, days are united
     */

    public List<RoutineDto> findAllByIdUnitedShedule(int id) {
        List<RoutineDto> dtoList = findAllById(id);

        if (dtoList.size() > 1) {
            dtoList = formatUnionShedule(dtoList);
        }


        return dtoList;
    }

    public RoutineListsDto findAlldUnitedShedule() {
        RoutineListsDto respList = new RoutineListsDto(new LinkedList<>());
        List<RoutineDto> dtoListDirty = this.findAll();
        Set<Integer> ids = new TreeSet<>();
        for (int q=0; q<dtoListDirty.size(); q++) {
            ids.add(dtoListDirty.get(q).getId());
        }
        Iterator it = ids.iterator();

        while(it.hasNext()){
            respList.appendList(this.findAllByIdUnitedShedule((Integer)it.next()));
        }


/*        List<RoutineDto> dtoList = this.findAll(); // sorted by id


        dtoList = dtoList.stream() // sort as Days orderBy it
                .sorted(Comparator.comparingInt(p -> p.getPnDaynamesByDayofweek().getOrderby()))
                .collect(Collectors.toList());

    *//*    dtoList = dtoList.stream() // sort as D
                .sorted(Comparator.comparingInt(RoutineDto::getId))
                .collect(Collectors.toList());*//*
      *//*  dtoList = dtoList.stream() // sort as Days orderBy it
                .sorted(Comparator.comparingInt(p -> p.getPnDaynamesByDayofweek().getOrderby()))
                .collect(Collectors.toList());*//*

        RoutineListsDto respList = new RoutineListsDto(new LinkedList<>());
        // get list where id is the same
        int firstId = dtoList.get(0).getId();
        List<RoutineDto> rawList = new LinkedList<>();
        for (RoutineDto inList : dtoList) {   // through all
            //rawList.add(inList);
            if (firstId == inList.getId()) {
                rawList.add(inList);
                //System.out.println(inList.getId());
            } else {
                rawList = rawList.stream()
                        //.sorted(Comparator.comparingInt(p -> p.getId()))
                        .sorted(Comparator.comparingInt(p -> p.getPnDaynamesByDayofweek().getOrderby()))
                        .collect(Collectors.toList());  // sort it
                if (rawList.size() > 1) { // format and append if more then one
                    rawList = formatUnionShedule(rawList);
                    respList.appendList(rawList);
                } else { //append if one
                    List<RoutineDto> tempIn = new LinkedList<>();
                    tempIn.add(inList);
                    respList.appendList(tempIn);
                }
                rawList = new LinkedList<>(); // renew
                firstId = inList.getId() + 1; // renew label firsId
            }
        }

     *//*   List<RoutineDto> l = respList.getLists();
        rawList = rawList.stream()
                //.sorted(Comparator.comparingInt(p -> p.getId()))
                .sorted(Comparator.comparingInt(p -> p.getPnDaynamesByDayofweek().getOrderby()))
                .collect(Collectors.toList());*//*
        return respList;*/
        return respList;
    }

    /**
     * @param list
     * @return formatted and united List
     */
    private List<RoutineDto> formatUnionShedule(List<RoutineDto> list) {
        final ListIterator<RoutineDto> iter = list.listIterator();
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
        return list;
    }
}
