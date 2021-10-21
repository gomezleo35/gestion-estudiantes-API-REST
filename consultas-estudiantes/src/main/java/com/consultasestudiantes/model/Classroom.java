package com.consultasestudiantes.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Classroom {

    @ApiModelProperty(notes = "Nombre del curso", example = "1A")
    private String nameClassroom;

    @ApiModelProperty(notes = "Promedio general del curso", example = "6.02")
    private Double average;

    @ApiModelProperty(notes = "Lista de alumnos")
    private List<Student> students;




}
