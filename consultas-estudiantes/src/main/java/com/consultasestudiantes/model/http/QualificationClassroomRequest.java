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

public class QualificationClassroomRequest {

    @ApiModelProperty(notes = "Id del curso", example = "1", required = true)
    private String idClassroom;
}
