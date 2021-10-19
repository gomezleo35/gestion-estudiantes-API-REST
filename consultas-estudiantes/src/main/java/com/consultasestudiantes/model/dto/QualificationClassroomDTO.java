package com.consultasestudiantes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QualificationClassroomDTO {

    private Integer idStudent;
    private String fullNameStudent;
    private Integer idSubject;
    private String description;
    private Double qualification;
}