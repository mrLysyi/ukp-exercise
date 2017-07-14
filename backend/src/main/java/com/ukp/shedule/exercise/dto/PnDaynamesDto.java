package com.ukp.shedule.exercise.dto;


import com.ukp.shedule.exercise.domains.PnDaynamesEntity;

public class PnDaynamesDto {
    private short id;
    private String name;
    private Integer countday;
    private Integer orderby;
    private String shortName;
    private String days;

    public PnDaynamesDto() {
    }

    public PnDaynamesDto(PnDaynamesEntity pnDaynamesEntity) {
        this.id = pnDaynamesEntity.getId();
        this.name = pnDaynamesEntity.getName();
        this.countday = pnDaynamesEntity.getCountday();
        this.orderby = pnDaynamesEntity.getOrderby();
        this.shortName = pnDaynamesEntity.getShortName();
        this.days = pnDaynamesEntity.getDays();
    }
}
