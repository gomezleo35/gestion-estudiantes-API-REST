package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.http.QualificationsResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class QualificationsResponseAdapter implements Function<List<Subject>, QualificationsResponse> {


    @Override
    public QualificationsResponse apply(List<Subject> subjects) {
        return QualificationsResponse.builder()
                .studentQualifications(subjects)
                .build();
    }
}
