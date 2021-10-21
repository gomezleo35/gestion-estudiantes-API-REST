package com.consultasestudiantes.model.dto;

import com.consultasestudiantes.model.Qualification;
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
public class StudentQualificationsDTO {

    private Integer idStudent;
    private String fullNameStudent;
    private List<Qualification> qualifications;
}
