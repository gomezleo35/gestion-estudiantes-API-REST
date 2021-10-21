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
public class Student {

    private Integer idStudent;
    private String fullName;
    private Double average;
    private List<Subject> subjectsStudent;
}
