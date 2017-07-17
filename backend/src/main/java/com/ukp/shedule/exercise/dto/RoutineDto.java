package com.ukp.shedule.exercise.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.ukp.shedule.exercise.domains.PnDaynamesEntity;
import com.ukp.shedule.exercise.domains.RoutineEntity;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class RoutineDto {
    private int idOrigin; // database distinct id
    @NotNull(message = "error.id.routine.notnull")
    private int id; // can by duplicated in DB

    @JsonFormat(pattern="HH:mm")
    private Timestamp workfrom;
    @JsonFormat(pattern="HH:mm")
    private Timestamp workto;
    @JsonFormat(pattern="HH:mm")
    private Timestamp intervalfrom;
    @JsonFormat(pattern="HH:mm")
    private Timestamp intervalto;

    private PnDaynamesEntity pnDaynamesByDayofweek; // convert to DTO !
    private PnDaynamesEntity pnDaynamesPeriodTo; // empty by default

    private Boolean intervalActive = false; // aditional variable


/*    public RoutineDto() {
    }*/

    public RoutineDto(RoutineEntity routineEntity) {
        this.idOrigin = routineEntity.getIdOrigin();
        this.id = routineEntity.getId();
        this.workfrom = routineEntity.getWorkfrom();
        this.workto = routineEntity.getWorkto();
        this.intervalfrom = routineEntity.getIntervalfrom();
        this.intervalto = routineEntity.getIntervalto();
        this.pnDaynamesByDayofweek = routineEntity.getPnDaynamesByDayofweek() ;
        if(!intervalfrom.equals(intervalto)){ //interval activation if not equals
            intervalActive = true;
        }
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

    public Boolean getIntervalActive() {
        return intervalActive;
    }

    public PnDaynamesEntity getPnDaynamesPeriodTo() {
        return pnDaynamesPeriodTo;
    }

    public void setPnDaynamesPeriodTo(PnDaynamesEntity pnDaynamesPeriodTo) {
        this.pnDaynamesPeriodTo = pnDaynamesPeriodTo;
    }

    public boolean equalsForUnio(Object o){
        if (!(o instanceof RoutineDto)) return false;
        RoutineDto that = (RoutineDto) o;
        if (getId() != that.getId()) return false; //compare  RoutineDto
        if (!getWorkfrom().equals(that.getWorkfrom())) return false;
        if (!getWorkto().equals(that.getWorkto())) return false;
        if (!getIntervalfrom().equals(that.getIntervalfrom())) return false;
        if (!getIntervalto().equals(that.getIntervalto())) return false;
        if(this.getPnDaynamesByDayofweek().getCountday() > 1) return false; // PnDaynamesByDayofweek - countdays > 1
        return this.getPnDaynamesByDayofweek().getCountday().equals(that.getPnDaynamesByDayofweek().getCountday()); //compare by countday
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoutineDto)) return false;

        RoutineDto that = (RoutineDto) o;

        if (getId() != that.getId()) return false;
        if (!getWorkfrom().equals(that.getWorkfrom())) return false;
        if (!getWorkto().equals(that.getWorkto())) return false;
        if (!getIntervalfrom().equals(that.getIntervalfrom())) return false;
        if (!getIntervalto().equals(that.getIntervalto())) return false;
        return getPnDaynamesByDayofweek().equals(that.getPnDaynamesByDayofweek());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getWorkfrom().hashCode();
        result = 31 * result + getWorkto().hashCode();
        result = 31 * result + getIntervalfrom().hashCode();
        result = 31 * result + getIntervalto().hashCode();
        result = 31 * result + getPnDaynamesByDayofweek().hashCode();
        return result;
    }
}
