package com.consultasestudiantes.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SubjectDTO {

    private Integer id;
    private String description;
    private List<Double> grades;
}
