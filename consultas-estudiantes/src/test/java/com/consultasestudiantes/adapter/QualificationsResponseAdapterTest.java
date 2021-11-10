package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.http.QualificationsResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class QualificationsResponseAdapterTest {

    private static final String nameSubject1 = "matematicas";
    private static final String nameSubject2 = "fisica";
    private static final Double average1 = 8.0;
    private static final Integer id1 = 1;
    private static final Integer id2 = 2;

    QualificationsResponseAdapter sut = new QualificationsResponseAdapter();

    @Test
    @DisplayName("Should return response model correctly")
    public void Should_return_response_model_correctly(){

        List<Subject> subjectList = new ArrayList<>();

        subjectList.add(Subject.builder()
                .id(id1)
                .description(nameSubject1)
                .average(average1)
                .build());

        subjectList.add(Subject.builder()
                .id(id2)
                .description(nameSubject2)
                .average(4.0).build());

        QualificationsResponse qualificationsResponse = QualificationsResponse.builder()
                .studentQualifications(subjectList)
                .build();

        QualificationsResponse actualQualificationsResponse = sut.apply(subjectList);

        assertThat(actualQualificationsResponse.getStudentQualifications().get(0).getId(),
                is(qualificationsResponse.getStudentQualifications().get(0).getId()));
        assertThat(actualQualificationsResponse.getStudentQualifications().get(0).getAverage(),
                is(qualificationsResponse.getStudentQualifications().get(0).getAverage()));
        assertThat(actualQualificationsResponse.getStudentQualifications().get(0).getDescription(),
                is(qualificationsResponse.getStudentQualifications().get(0).getDescription()));
    }

}