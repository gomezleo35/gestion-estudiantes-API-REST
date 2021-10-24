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
public class DeleteSubjectDTO {

    @ApiModelProperty(notes = "Id de estudiante", example = "1", required = true)
    private String idStudent;

    @ApiModelProperty(notes = "Id de materia", example = "1", required = true)
    private String idSubject;
}
