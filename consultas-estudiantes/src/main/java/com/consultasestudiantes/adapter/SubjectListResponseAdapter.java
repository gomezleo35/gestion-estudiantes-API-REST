package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.http.SubjectsListResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class SubjectListResponseAdapter implements Function<List<EnrolledSubject>, SubjectsListResponse> {

    @Override
    public SubjectsListResponse apply(List<EnrolledSubject> enrolledSubjects) {
        return SubjectsListResponse.builder()
                .enrolledSubjectList(enrolledSubjects)
                .build();
    }
}
