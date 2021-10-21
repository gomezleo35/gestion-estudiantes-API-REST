package com.consultasestudiantes.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class    QualificationClassroomDTO {

    @ApiModelProperty(notes = "Id de estudiante", example = "1", required = true)
    private Integer idStudent;

    @ApiModelProperty(notes = "Nombre completo de estudiante", example = "Juan Perez", required = true)
    private String fullNameStudent;

    @ApiModelProperty(notes = "Id de materia", example = "1", required = true)
    private Integer idSubject;

    @ApiModelProperty(notes = "Nombre de materia", example = "Química", required = true)
    private String description;

    @ApiModelProperty(notes = "Nota de materia", example = "7.5", required = true)
    private Double qualification;

    @ApiModelProperty(notes = "Identificación del curso", example = "1 A", required = true)
    private String nameClassroom;
}