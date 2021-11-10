package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.model.Student;
import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.dto.StudentQualificationsDTO;
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

class StudentListAdapterTest {

    private static final Double qualification2 = 6.0;
    private static final Double qualification1 = 7.0;
    private static final Integer idSubject1 = 1;
    private static final Integer idStudent1 = 1;
    private static final String subjectDescription1 = "matematicas";
    private static final String subjectDescription2 = "fisica";
    private static final String fullNameStudent = "leo gomez";
    private static final Integer idSubject2 = 2;

    @Mock
    private SubjectDtoListAdapter mockSubjectDtoListAdapter;

    @Mock
    private SubjectListAdapter mockSubjectListAdapter;

    private StudentListAdapter sut;

    @BeforeEach
    private void setUp(){
        initMocks(this);
        sut = new StudentListAdapter(mockSubjectDtoListAdapter, mockSubjectListAdapter) ;
    }

    @Test
    public void should_return_list_model_correctly(){
        List<StudentQualificationsDTO> dtoList = new ArrayList<>();
        List<Student> studentList = obtainStudentList();

        dtoList.add(StudentQualificationsDTO.builder()
                .idStudent(idStudent1)
                .fullNameStudent(fullNameStudent)
                .qualifications(obtainQualificationList())
                .build());

        when(sut.apply(dtoList)).thenReturn(studentList);

        List<Student> actualStudentsList = sut.apply(dtoList);

        assertThat(actualStudentsList.get(0).getIdStudent(), is(studentList.get(0).getIdStudent()));
        assertThat(actualStudentsList.get(0).getAverage(), is(studentList.get(0).getAverage()));
        assertThat(actualStudentsList.get(0).getFullName(), is(studentList.get(0).getFullName()));
        assertThat(actualStudentsList.get(0).getSubjectsStudent().get(0).getId(),
                is(studentList.get(0).getSubjectsStudent().get(0).getId()));
        assertThat(actualStudentsList.get(0).getSubjectsStudent().get(0).getDescription(),
                is(studentList.get(0).getSubjectsStudent().get(0).getDescription()));
        assertThat(actualStudentsList.get(0).getSubjectsStudent().get(0).getAverage(),
                is(studentList.get(0).getSubjectsStudent().get(0).getAverage()));

    }

    private List<Student> obtainStudentList (){
        return newArrayList(
                Student.builder()
                        .idStudent(1)
                        .fullName(fullNameStudent)
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