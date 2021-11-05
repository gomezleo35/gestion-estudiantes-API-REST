package com.consultasestudiantes.service.imp;

import com.consultasestudiantes.adapter.StudentDtoListAdapter;
import com.consultasestudiantes.adapter.StudentListAdapter;
import com.consultasestudiantes.adapter.SubjectDtoListAdapter;
import com.consultasestudiantes.model.Classroom;
import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.model.Student;
import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.dto.QualificationClassroomDTO;
import com.consultasestudiantes.model.dto.StudentQualificationsDTO;
import com.consultasestudiantes.respository.QualificationsClassroomClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class QualificationClassroomServiceImpTest {

    private static final String nameClassroom = "1A";
    private static final String subjectDescription1 = "matematica";
    private static final String subjectDescription2 = "fisica";
    private static final String nameStudent = "leo gomez";
    private static final Integer idSubject1 = 1;
    private static final Integer idSubject2 = 2;
    private static final Double qualification1 = 5.0;
    private static final Double qualification2 = 6.0;

    @Mock
    private QualificationsClassroomClient mockQualificationsClassroomClient;

    @Mock
    private StudentDtoListAdapter mockStudentDtoListAdapter;

    @Mock
    private StudentListAdapter mockStudentListAdapter;

    private QualificationClassroomServiceImp sut;

    @BeforeEach
    private void setUp(){
        initMocks(this);
        sut = new QualificationClassroomServiceImp(mockQualificationsClassroomClient,
                mockStudentDtoListAdapter, mockStudentListAdapter);
    }

    @Test
    public void should_returns_list_correctly_when_obtainClassroom_is_success (){
        List<QualificationClassroomDTO> qualificationClassroomDTOList = obtainQualificationClassroomDTO();
        List<StudentQualificationsDTO> studentQualificationsDTOS = obtainStudentQualificationList();
        List<Student> studentList = obtainStudentList();
        when(mockQualificationsClassroomClient.obtainQualificationsClassroom("1"))
                .thenReturn(qualificationClassroomDTOList);
        when(mockStudentDtoListAdapter.apply(qualificationClassroomDTOList)).thenReturn(studentQualificationsDTOS);
        when(mockStudentListAdapter.apply(studentQualificationsDTOS)).thenReturn(obtainStudentList());

        Classroom classroom = sut.obtainClassroom("1");

        assertThat(classroom.getNameClassroom(), is(nameClassroom));
        assertThat(classroom.getAverage(), is(5.5));
        assertThat(classroom.getStudents().get(0).getIdStudent(), is(studentList.get(0).getIdStudent()));
        assertThat(classroom.getStudents().get(0).getAverage(), is(studentList.get(0).getAverage()));
        assertThat(classroom.getStudents().get(0).getSubjectsStudent().get(0).getDescription(),
                is(studentList.get(0).getSubjectsStudent().get(0).getDescription()));
        assertThat(classroom.getStudents().get(0).getSubjectsStudent().get(0).getId(),
                is(studentList.get(0).getSubjectsStudent().get(0).getId()));
        assertThat(classroom.getStudents().get(0).getSubjectsStudent().get(0).getAverage(),
                is(studentList.get(0).getSubjectsStudent().get(0).getAverage()));
    }

    private List<QualificationClassroomDTO> obtainQualificationClassroomDTO (){
        return newArrayList(
                QualificationClassroomDTO.builder()
                        .nameClassroom(nameClassroom)
                        .description(subjectDescription1)
                        .idSubject(idSubject1)
                        .qualification(qualification1)
                        .idStudent(1)
                        .fullNameStudent(nameStudent)
                        .build(),
                QualificationClassroomDTO.builder()
                        .nameClassroom(nameClassroom)
                        .description(subjectDescription2)
                        .idSubject(idSubject2)
                        .qualification(qualification2)
                        .idStudent(1)
                        .fullNameStudent(nameStudent)
                        .build()
        );
    }

    private List<StudentQualificationsDTO> obtainStudentQualificationList (){
        return newArrayList(
                StudentQualificationsDTO.builder()
                        .idStudent(1)
                        .fullNameStudent(nameStudent)
                        .qualifications(obtainQualificationList())
                        .build()
        );
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

    private List<Student> obtainStudentList (){
        return newArrayList(
                Student.builder()
                        .idStudent(1)
                        .fullName(nameStudent)
                        .average(5.5)
                        .subjectsStudent(newArrayList(
                                Subject.builder()
                                        .id(idSubject1)
                                        .description(subjectDescription1)
                                        .average(qualification1)
                                        .build(),
                                Subject.builder()
                                        .id(idSubject2)
                                        .description(subjectDescription2)
                                        .average(qualification2)
                                        .build()
                        ))
                        .build()
        );
    }

}