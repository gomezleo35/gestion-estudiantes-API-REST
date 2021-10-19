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
public class Qualification {

    @ApiModelProperty(notes = "Id de la materia", example = "7.5")
    private Integer idSubject;

    @ApiModelProperty(notes = "Nombre de la materia", example = "Matemáticas")
    private String description;

    @ApiModelProperty(notes = "Calificación", example = "7.4")
    private Double qualification;
}
