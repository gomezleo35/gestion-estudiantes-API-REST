package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.model.dto.QualificationClassroomDTO;
import com.consultasestudiantes.model.dto.StudentQualificationsDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class StudentDtoListAdapterTest {

    private static final Double qualification2 = 6.0;
    private static final Double qualification1 = 7.0;
    private static final String nameClassroom = "1A";
    private static final Integer idSubject1 = 1;
    private static final Integer idStudent1 = 1;
    private static final String subjectDescription1 = "matematicas";
    private static final String subjectDescription2 = "fisica";
    private static final String fullNameStudent = "leo gomez";
    private static final Integer idSubject2 = 2;

    @Test
    @DisplayName("Should return DTO model correctly")
    public void Should_return_DTO_model_correctly(){
        List<QualificationClassroomDTO> dtoList = new ArrayList<>();
        List<StudentQualificationsDTO> studentQualificationsDTOS = new ArrayList<>();
        List<Qualification> qualifications = obtainQualificationList();

        dtoList.add(QualificationClassroomDTO.builder()
                        .idStudent(idStudent1)
                        .description(subjectDescription1)
                        .idSubject(idSubject1)
                        .fullNameStudent(fullNameStudent)
                        .qualification(qualification1)
                        .nameClassroom(nameClassroom)
                .build());

        dtoList.add(QualificationClassroomDTO.builder()
                .idStudent(idStudent1)
                .description(subjectDescription1)
                .idSubject(idSubject1)
                .fullNameStudent(fullNameStudent)
                .qualification(qualification2)
                .nameClassroom(nameClassroom)
                .build());



        dtoList.add(QualificationClassroomDTO.builder()
                .idStudent(idStudent1)
                .description(subjectDescription2)
                .idSubject(idSubject2)
                .fullNameStudent(fullNameStudent)
                .qualification(qualification2)
                .nameClassroom(nameClassroom)
                .build());

        dtoList.add(QualificationClassroomDTO.builder()
                .idStudent(idStudent1)
                .description(subjectDescription2)
                .idSubject(idSubject2)
                .fullNameStudent(fullNameStudent)
                .qualification(3.0)
                .nameClassroom(nameClassroom)
                .build());

        studentQualificationsDTOS.add(StudentQualificationsDTO.builder()
                        .idStudent(idStudent1)
                        .fullNameStudent(fullNameStudent)
                        .qualifications(qualifications)
                .build());





    }

    private List<Qualification> obtainQualificationList (){
        return newArrayList(
                Qualification.builder()
                        .description(subjectDescription1)
                        .idSubject(idSubject1)
                        .qualification(qualification1)
                        .build(),
                Qualification.builder()
                        .qualification(qualification2)
                        .idSubject(idSubject1)
                        .description(subjectDescription1)
                        .build()
        );
    }
}