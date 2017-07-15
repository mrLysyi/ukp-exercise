package com.ukp.shedule.exercise.dto;


import com.ukp.shedule.exercise.domains.PnDaynamesEntity;

public class PnDaynamesDto {
    private short id;
    private String name;
    private Integer countday;
    private Integer orderby;
    private String shortName;
    private String days;

 /*   public PnDaynamesDto() {
    }*/

    public PnDaynamesDto(PnDaynamesEntity pnDaynamesEntity) {
        this.id = pnDaynamesEntity.getId();
        this.name = pnDaynamesEntity.getName();
        this.countday = pnDaynamesEntity.getCountday();
        this.orderby = pnDaynamesEntity.getOrderby();
        this.shortName = pnDaynamesEntity.getShortName();
        this.days = pnDaynamesEntity.getDays();
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountday() {
        return countday;
    }

    public void setCountday(Integer countday) {
        this.countday = countday;
    }

    public Integer getOrderby() {
        return orderby;
    }

    public void setOrderby(Integer orderby) {
        this.orderby = orderby;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }
}
