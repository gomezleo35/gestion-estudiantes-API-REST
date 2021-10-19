package com.consultasestudiantes.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {

    @ApiModelProperty(notes = "Id de materia", example = "1")
    private Integer id;

    @ApiModelProperty(notes = "Nombre de la materia", example = "Física")
    private String description;

    @ApiModelProperty(notes = "Promedio general de la materia", example = "6.02")
    private Double average;
}
