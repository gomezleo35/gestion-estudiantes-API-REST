package com.consultasestudiantes.service.imp;

import com.consultasestudiantes.model.Classroom;
import com.consultasestudiantes.model.Student;
import com.consultasestudiantes.model.dto.QualificationClassroomDTO;
import com.consultasestudiantes.model.dto.StudentQualificationsDTO;
import com.consultasestudiantes.respository.QualificationsClassroomClient;
import com.consultasestudiantes.service.QualificationsClassroomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.consultasestudiantes.utils.ObtainAverage.obtainAverage;

@Service
public class QualificationClassroomServiceImp implements QualificationsClassroomService {

    private final QualificationsClassroomClient qualificationsClassroomClient;
    private final Function<List<QualificationClassroomDTO>, List<StudentQualificationsDTO>> studentDtoListAdapter;
    private final Function<List<StudentQualificationsDTO>, List<Student>> studentListAdapter;

    public QualificationClassroomServiceImp(QualificationsClassroomClient qualificationsClassroomClient,
                                            Function<List<QualificationClassroomDTO>, List<StudentQualificationsDTO>> studentDtoListAdapter,
                                            Function<List<StudentQualificationsDTO>, List<Student>> studentListAdapter) {
        this.qualificationsClassroomClient = qualificationsClassroomClient;
        this.studentDtoListAdapter = studentDtoListAdapter;
        this.studentListAdapter = studentListAdapter;
    }


    @Override
    public Classroom obtainClassroom(String classroomId) {
        List<QualificationClassroomDTO> qualificationsRoom = qualificationsClassroomClient
                .obtainQualificationsClassroom(classroomId);
        List<StudentQualificationsDTO> qualificationsDTOS = studentDtoListAdapter.apply(qualificationsRoom);
        List<Student> studentList = studentListAdapter.apply(qualificationsDTOS);
        List<Double> grades = new ArrayList<>();

        studentList.stream().forEach(student -> grades.add(student.getAverage()));
        Double average = obtainAverage(grades);

        return Classroom.builder()
                .nameClassroom(qualificationsRoom.get(0).getNameClassroom())
                .students(studentList)
                .average(average)
                .build();
    }
}
