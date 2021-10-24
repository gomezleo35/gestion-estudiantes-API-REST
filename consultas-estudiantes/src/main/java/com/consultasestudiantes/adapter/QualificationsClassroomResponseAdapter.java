package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Classroom;
import com.consultasestudiantes.model.http.QualificationsClassroomResponse;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class QualificationsClassroomResponseAdapter  implements Function<Classroom, QualificationsClassroomResponse> {
    @Override
    public QualificationsClassroomResponse apply(Classroom classroom) {

        return QualificationsClassroomResponse.builder().
                nameClassroom(classroom.getNameClassroom())
                .students(classroom.getStudents())
                .average(classroom.getAverage())
                .build();
    }
}
