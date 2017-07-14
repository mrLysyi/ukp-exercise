package com.ukp.shedule.exercise.dto;


import com.ukp.shedule.exercise.domains.PnDaynamesEntity;
import com.ukp.shedule.exercise.domains.RoutineEntity;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class RoutineDto {
    private int idOrigin;
    @NotNull(message = "error.id.notnull")
    private int id;
    private Timestamp workfrom;
    private Timestamp workto;
    private Timestamp intervalfrom;
    private Timestamp intervalto;
    private PnDaynamesEntity pnDaynamesByDayofweek;

    public RoutineDto() {
    }

    public RoutineDto(RoutineEntity routineEntity) {
        this.idOrigin = routineEntity.getIdOrigin();
        this.id = routineEntity.getId();
        this.workfrom = routineEntity.getWorkfrom();
        this.workto = routineEntity.getWorkto();
        this.intervalfrom = routineEntity.getIntervalfrom();
        this.intervalto = routineEntity.getIntervalto();
        this.pnDaynamesByDayofweek = routineEntity.getPnDaynamesByDayofweek() ;
    }

    public int getIdOrigin() {
        return idOrigin;
    }

    public void setIdOrigin(int idOrigin) {
        this.idOrigin = idOrigin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getWorkfrom() {
        return workfrom;
    }

    public void setWorkfrom(Timestamp workfrom) {
        this.workfrom = workfrom;
    }

    public Timestamp getWorkto() {
        return workto;
    }

    public void setWorkto(Timestamp workto) {
        this.workto = workto;
    }

    public Timestamp getIntervalfrom() {
        return intervalfrom;
    }

    public void setIntervalfrom(Timestamp intervalfrom) {
        this.intervalfrom = intervalfrom;
    }

    public Timestamp getIntervalto() {
        return intervalto;
    }

    public void setIntervalto(Timestamp intervalto) {
        this.intervalto = intervalto;
    }

    public PnDaynamesEntity getPnDaynamesByDayofweek() {
        return pnDaynamesByDayofweek;
    }

    public void setPnDaynamesByDayofweek(PnDaynamesEntity pnDaynamesByDayofweek) {
        this.pnDaynamesByDayofweek = pnDaynamesByDayofweek;
    }
}
