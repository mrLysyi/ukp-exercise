package com.ukp.shedule.exercise.dto;


import javax.validation.constraints.NotNull;

public class ResponseRoutineDto {
    @NotNull(message = "error.id.routine.notnull")
    private int id;

}
