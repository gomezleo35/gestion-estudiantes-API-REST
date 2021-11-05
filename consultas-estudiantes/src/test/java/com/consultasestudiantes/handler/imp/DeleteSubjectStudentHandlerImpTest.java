package com.consultasestudiantes.handler.imp;

import com.consultasestudiantes.adapter.DeleteRequestAdapter;
import com.consultasestudiantes.adapter.SubjectListResponseAdapter;
import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import com.consultasestudiantes.model.http.SubjectsListResponse;
import com.consultasestudiantes.service.DeleteSubjectService;
import com.consultasestudiantes.validator.DeleteSubjectRequestValidator;
import com.consultasestudiantes.validator.Validator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class DeleteSubjectStudentHandlerImpTest {

    @Mock
    private DeleteSubjectService mockDeleteSubjectService;

    @Mock
    private DeleteSubjectRequestValidator mockDeleteSubjectRequestValidator;

    @Mock
    private DeleteRequestAdapter mockDeleteRequestAdapter;

    @Mock
    private SubjectListResponseAdapter mockSubjectListResponseAdapter;

    private DeleteSubjectStudentHandlerImp sut;

    @BeforeEach
    private void setUp(){
        initMocks(this);

        sut = new DeleteSubjectStudentHandlerImp(mockDeleteSubjectService,
                mockDeleteSubjectRequestValidator,
                mockDeleteRequestAdapter,
                mockSubjectListResponseAdapter);
    }

    @Test
    public void should_returns_list_correctly_when_obtainSubjects_is_success (){
        DeleteSubjectRequest deleteSubjectRequest = DeleteSubjectRequest.builder()
                .idStudent("1")
                .idSubject("2")
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

        SubjectsListResponse subjectsListResponse = SubjectsListResponse.builder()
                .enrolledSubjectList(subjectList)
                .build();

        when(mockSubjectListResponseAdapter.apply(
                mockDeleteSubjectService.deleteSubject(
                        mockDeleteRequestAdapter.apply(deleteSubjectRequest)))).thenReturn(subjectsListResponse);

        SubjectsListResponse actualSubjectsListResponse = sut.handleDeleteSubjectStudent(deleteSubjectRequest);

        assertThat(actualSubjectsListResponse.getEnrolledSubjectList().get(0).getIdSubject(),
                is(subjectList.get(0).getIdSubject()));
        assertThat(actualSubjectsListResponse.getEnrolledSubjectList().get(0).getDescription(),
                is(subjectList.get(0).getDescription()));
    }
}