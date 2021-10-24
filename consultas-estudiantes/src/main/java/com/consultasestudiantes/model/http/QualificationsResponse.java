package com.consultasestudiantes.model.http;

import com.consultasestudiantes.model.Subject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QualificationsResponse {

    private List<Subject> studentQualifications;
    private String errorMessage;
}
