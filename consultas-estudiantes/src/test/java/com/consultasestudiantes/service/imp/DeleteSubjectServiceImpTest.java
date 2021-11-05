package com.consultasestudiantes.service.imp;

import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.respository.DeleteSubjectClient;
import com.consultasestudiantes.respository.ListSubjectClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class DeleteSubjectServiceImpTest {

    @Mock
    private ListSubjectClient mockListSubjectClient;

    @Mock
    private DeleteSubjectClient mockDeleteSubjectClient;

    private DeleteSubjectServiceImp sut;

    @BeforeEach
    public void setUp() {
        initMocks(this);

        sut = new DeleteSubjectServiceImp(mockDeleteSubjectClient,mockListSubjectClient);
    }

    @Test
    public void should_returns_list_correctly_when_obtainSubject_is_success (){
        DeleteSubjectDTO deleteSubjectDTO = new DeleteSubjectDTO();

        List<EnrolledSubject> subjectList = new ArrayList<>();

        subjectList.add(EnrolledSubject.builder()
                .idSubject(1)
                .description("matematicas")
                .build());
        subjectList.add(EnrolledSubject.builder()
                .idSubject(2)
                .description("fisica")
                .build());

        sut.deleteSubject(deleteSubjectDTO);

        verify(mockDeleteSubjectClient).deleteSubject(deleteSubjectDTO);

        when(mockListSubjectClient.obtainSubjects(deleteSubjectDTO)).thenReturn(subjectList);

        List<EnrolledSubject> actualSubjectList = sut.deleteSubject(deleteSubjectDTO);

        assertThat(actualSubjectList.get(0).getIdSubject(), is(subjectList.get(0).getIdSubject()));
        assertThat(actualSubjectList.get(0).getDescription(), is(subjectList.get(0).getDescription()));
    }

}