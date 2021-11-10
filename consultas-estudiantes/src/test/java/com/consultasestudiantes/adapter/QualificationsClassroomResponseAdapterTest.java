package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Classroom;
import com.consultasestudiantes.model.Student;
import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.http.QualificationsClassroomResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QualificationsClassroomResponseAdapterTest {

    private static final String nameClassroom = "1A";
    private static final String nameSubject1 = "matematicas";
    private static final String nameSubject2 = "fisica";
    private static final String nameStudent1 = "leo gomez";
    private static final String nameStudent2 = "gabi alvarez";
    private static final Double average3 = 6.5;
    private static final Double average1 = 8.0;
    private static final Integer id1 = 1;
    private static final Integer id2 = 2;

    QualificationsClassroomResponseAdapter sut = new QualificationsClassroomResponseAdapter();


    @Test
    @DisplayName("Should return response model correctly")
    public void Should_return_response_model_correctly(){

        List<Student> students = new ArrayList<>();
        List<Subject> subjectList1 = new ArrayList<>();
        List<Subject> subjectList2 = new ArrayList<>();



        subjectList1.add(Subject.builder()
                .id(id1)
                .description(nameSubject1)
                .average(average1)
                .build());


        subjectList1.add(Subject.builder()
                .id(id2)
                .description(nameSubject2)
                .average(4.0).build());

        subjectList2.add(Subject.builder()
                .id(id1)
                .description(nameSubject1)
                .average(average1)
                .build());
        subjectList2.add(Subject.builder()
                .id(id2)
                .description(nameSubject2)
                .average(6.0).build());


        students.add(Student.builder()
                .fullName(nameStudent1)
                .average(6.0)
                .idStudent(id1)
                .subjectsStudent(subjectList1)
                .build());


        students.add(Student.builder()
                .fullName(nameStudent2)
                .average(7.0)
                .idStudent(id2)
                .subjectsStudent(subjectList2)
                .build());

        Classroom classroom = Classroom.builder()
                .nameClassroom(nameClassroom)
                .average(average3)
                .students(students)
                .build();

        QualificationsClassroomResponse qualificationsClassroomResponse = QualificationsClassroomResponse.builder()
                .nameClassroom("1A")
                .average(average3)
                .students(students)
                .build();

        QualificationsClassroomResponse actualQualificationsClassroomResponse = sut.apply(classroom);

        assertThat(actualQualificationsClassroomResponse.getNameClassroom(),
                is(qualificationsClassroomResponse.getNameClassroom()));
        assertThat(actualQualificationsClassroomResponse.getAverage(),
                is(qualificationsClassroomResponse.getAverage()));
        assertThat(actualQualificationsClassroomResponse.getStudents().get(0).getIdStudent(),
                is(qualificationsClassroomResponse.getStudents().get(0).getIdStudent()));
        assertThat(actualQualificationsClassroomResponse.getStudents().get(0).getAverage(),
                is(qualificationsClassroomResponse.getStudents().get(0).getAverage()));
        assertThat(actualQualificationsClassroomResponse.getStudents().get(0).getFullName(),
                is(qualificationsClassroomResponse.getStudents().get(0).getFullName()));
        assertThat(actualQualificationsClassroomResponse.getStudents().get(0).getSubjectsStudent().get(0).getId(),
                is(qualificationsClassroomResponse.getStudents().get(0).getSubjectsStudent().get(0).getId()));
        assertThat(actualQualificationsClassroomResponse.getStudents().get(0).getSubjectsStudent().get(0).getDescription(),
                is(qualificationsClassroomResponse.getStudents().get(0).getSubjectsStudent().get(0).getDescription()));
        assertThat(actualQualificationsClassroomResponse.getStudents().get(0).getSubjectsStudent().get(0).getAverage(),
                is(qualificationsClassroomResponse.getStudents().get(0).getSubjectsStudent().get(0).getAverage()));

    }
}
