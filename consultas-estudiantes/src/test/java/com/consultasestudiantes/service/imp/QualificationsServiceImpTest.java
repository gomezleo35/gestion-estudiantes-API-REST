package com.consultasestudiantes.service.imp;

import com.consultasestudiantes.adapter.SubjectDtoListAdapter;
import com.consultasestudiantes.adapter.SubjectListAdapter;
import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.dto.SubjectDTO;
import com.consultasestudiantes.respository.QualificationsClient;
import com.consultasestudiantes.service.QualificationsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class QualificationsServiceImpTest   {

    @Mock
    private QualificationsClient mockQualificationsClient;
    @Mock
    private SubjectListAdapter subjectListAdapter;
    @Mock
    private SubjectDtoListAdapter subjectDtoListAdapter;

    private QualificationsService sut;



    @BeforeEach
    public void setUp(){
        initMocks(this);

        sut = new QualificationsServiceImp(mockQualificationsClient,
                 subjectDtoListAdapter, subjectListAdapter );
    }

    @Test
    public void should_returns_list_correctly_when_obtainQualifications_is_success (){

        List<Qualification> qualifications = new ArrayList<>();

        qualifications.add(Qualification.builder()
                .qualification(5.0)
                .idSubject(1)
                .description("química")
                .build());

        qualifications.add(Qualification.builder()
                .qualification(9.0)
                .idSubject(1)
                .description("química")
                .build());

        qualifications.add(Qualification.builder()
                .qualification(5.0)
                .idSubject(2)
                .description("fisica")
                .build());

        List<SubjectDTO> subjectDTOList = new ArrayList<>();

        subjectDTOList.add(SubjectDTO.builder()
                .description("química")
                .grades(newArrayList(5.0,9.0))
                .id(1).build());

        subjectDTOList.add(SubjectDTO.builder()
                .description("fisica")
                .grades(newArrayList(5.0))
                .id(2).build());

        String studentId = "1";

        List<Subject> subjects = new ArrayList<>();

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

        when(mockQualificationsClient.obtainQualifications(studentId)).thenReturn(qualifications);
        when(subjectDtoListAdapter.apply(qualifications)).thenReturn(subjectDTOList);
        when(subjectListAdapter.apply(subjectDTOList)).thenReturn(subjects);

        List<Subject> actualSubjectList = sut.obtainQualifications(studentId);

        assertThat(actualSubjectList.get(0).getId(), is(subjects.get(0).getId()));
        assertThat(actualSubjectList.get(0).getDescription(), is(subjects.get(0).getDescription()));
        assertThat(actualSubjectList.get(0).getAverage(), is(subjects.get(0).getAverage()));
    }
}