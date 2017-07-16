package com.ukp.shedule.exercise.dto;


import java.util.List;

public class RoutineListsDto {
    private List<List<RoutineDto>> lists;

    public RoutineListsDto(List<List<RoutineDto>> lists) {
        this.lists = lists;
    }

    public List<List<RoutineDto>> getLists() {
        return lists;
    }

    public void setLists(List<List<RoutineDto>> lists) {
        this.lists = lists;
    }

    /**
     * add to the end of list
     * @param l
     */
    public void appendList(List<RoutineDto> l){
 /*       boolean added = false;
       if (lists.size() > 0)
       for (int i = 0; i < lists.get(0).size(); i++){
           System.out.println("add-------------------"+i+" ");

           List<RoutineDto> tl = lists.get(i);
           if (lists.get(i).size() > 0)
           for (int j = 0; j < tl.size(); i++){

              *//*  if(lists.get(i).get(j).getId() == l.get(0).getId()){
                    this.lists.get(i).add(l.get(0));
                    added = true;
                }*//*
           }
       }
       if(!added){this.lists.add(l);}*/
        this.lists.add(l);
    }
}
