package com.consultasestudiantes.respository.imp;

import com.consultasestudiantes.mapper.ObtainSubjectsMapper;
import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.respository.ListSubjectClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


class ListSubjectClientImpTest {

    @Mock
    private ObtainSubjectsMapper mockObtainSubjectsMapper;

    private ListSubjectClient sut;

    @BeforeEach
    public void setUp (){
        initMocks(this);
        sut = new ListSubjectClientImp(mockObtainSubjectsMapper);
    }

    @Test
    public void should_returns_list_correctly_when_obtainSubjects_is_success (){
        DeleteSubjectDTO deleteSubjectDTO = DeleteSubjectDTO.builder()
                .idStudent("1")
                .idSubject("1")
                .build();

        List<EnrolledSubject> subjectList = new ArrayList<>();

        subjectList.add(EnrolledSubject.builder()
                .idSubject(1)
                .description("matematicas")
                .build());
        subjectList.add(EnrolledSubject.builder()
                .idSubject(2)
                .description("fisica")
                .build());

        when(mockObtainSubjectsMapper.obtainSubjects(deleteSubjectDTO)).thenReturn(subjectList);

        List<EnrolledSubject> actualSubjectList = sut.obtainSubjects(deleteSubjectDTO);

        assertThat(actualSubjectList.get(0).getIdSubject(), is(subjectList.get(0).getIdSubject()));
        assertThat(actualSubjectList.get(0).getDescription(), is(subjectList.get(0).getDescription()));
    }



}