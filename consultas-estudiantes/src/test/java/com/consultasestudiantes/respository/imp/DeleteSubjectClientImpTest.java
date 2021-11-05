package com.consultasestudiantes.respository.imp;

import com.consultasestudiantes.mapper.DeleteSubjectStudentMapper;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;


import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;


class DeleteSubjectClientImpTest {

    @Mock
    private DeleteSubjectStudentMapper mockDeleteSubjectStudentMapper;

    DeleteSubjectClientImp sut;

    @BeforeEach
    public void setUp(){
        initMocks(this);
        sut = new DeleteSubjectClientImp(mockDeleteSubjectStudentMapper);
    }

    @Test
    public void delete_correctly_function (){
        DeleteSubjectDTO deleteSubjectDTO = DeleteSubjectDTO.builder()
                .idSubject("1")
                .idStudent("1")
                .build();

        sut.deleteSubject(deleteSubjectDTO);

        verify(mockDeleteSubjectStudentMapper).deleteSubjectStudent(deleteSubjectDTO);
    }
}