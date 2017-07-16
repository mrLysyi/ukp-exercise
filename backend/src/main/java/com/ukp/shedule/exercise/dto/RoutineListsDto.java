package com.ukp.shedule.exercise.dto;


import java.util.List;

public class RoutineListsDto {
    private List<List<RoutineDto>> lists;

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
        this.lists.add(l);
    }
}
