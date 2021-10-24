package com.consultasestudiantes.model.http;


import com.consultasestudiantes.model.EnrolledSubject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectsListResponse {

    private List<EnrolledSubject> enrolledSubjectList;
    private String errorMessage;
}
