package com.consultasestudiantes.handler.imp;

import com.consultasestudiantes.adapter.QualificationsResponseAdapter;
import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.http.QualificationsRequest;
import com.consultasestudiantes.model.http.QualificationsResponse;
import com.consultasestudiantes.service.QualificationsService;
import com.consultasestudiantes.validator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class QualificationsHandlerImpTest {

    @Mock
    private QualificationsService mockQualificationsService;

    @Mock
    private QualificationsResponseAdapter qualificationsResponseAdapter;

    @Mock
    private Validator<QualificationsRequest> validator;

    private QualificationsHandlerImp sut;

    @BeforeEach
    public void setUp(){
        initMocks(this);

        sut = new QualificationsHandlerImp(mockQualificationsService, qualificationsResponseAdapter, validator);
    }

    @Test
    public void should_returns_list_correctly_when_obtainQualifications_is_success (){
        List<Subject> subjects = new ArrayList<>();

        String studentId = "1";

        subjects.add(Subject.builder()
                .id(1)
                .average(7.0)
                .description("quimica")
                .build());

        subjects.add(Subject.builder()
                .id(2)
                .average(5.0)
                .description("fisica")
                .build());

        QualificationsResponse qualificationsResponse = QualificationsResponse.builder()
                .studentQualifications(subjects)
                .build();

        QualificationsRequest qualificationsRequest = QualificationsRequest.builder()
                .studentId("1")
                .build();

        when(qualificationsResponseAdapter.apply(mockQualificationsService.obtainQualifications(studentId))).thenReturn(qualificationsResponse);

        QualificationsResponse actualQualificationsResponse = sut.handleQualificationsStudent(qualificationsRequest);


        assertThat(actualQualificationsResponse.getStudentQualifications().get(0).getAverage(),
                is(subjects.get(0).getAverage()));
        assertThat(actualQualificationsResponse.getStudentQualifications().get(1).getAverage(),
                is(subjects.get(1).getAverage()));
    }

}