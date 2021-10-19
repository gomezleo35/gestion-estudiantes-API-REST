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

public class QualificationsRequest {

    @ApiModelProperty(notes = "Id del estudiante", example = "1", required = true)
    private Integer studentId;    // lo mismo que el DTO
}
