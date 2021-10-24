package com.consultasestudiantes.model.http;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteSubjectRequest {

    @ApiModelProperty(notes = "Id de estudiante", example = "1", required = true)
    private String idStudent;

    @ApiModelProperty(notes = "Id de materia", example = "1", required = true)
    private String idSubject;
}
