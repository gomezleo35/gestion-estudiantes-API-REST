package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.model.dto.QualificationClassroomDTO;
import com.consultasestudiantes.model.dto.StudentQualificationsDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class StudentDtoListAdapter implements Function<List<QualificationClassroomDTO>, List<StudentQualificationsDTO>> {
    @Override
    public List<StudentQualificationsDTO> apply(List<QualificationClassroomDTO> qualificationsRoom) {

        List<StudentQualificationsDTO> dtoList = new ArrayList<>();

        for (QualificationClassroomDTO q : qualificationsRoom){
            Integer studentId = 0;

            if (dtoList.size() > 0){
                for(StudentQualificationsDTO s : dtoList ){
                    if( s.getIdStudent() == q.getIdStudent()){
                        Qualification qualification = Qualification.builder()
                                .idSubject(q.getIdSubject())
                                .description(q.getDescription())
                                .qualification(q.getQualification())
                                .build();
                        s.getQualifications().add(qualification);
                        studentId = q.getIdStudent();
                        break;
                    }
                }
            }

            if (studentId == 0){
                Qualification qualification = Qualification.builder()
                        .idSubject(q.getIdSubject())
                        .description(q.getDescription())
                        .qualification(q.getQualification())
                        .build();

                StudentQualificationsDTO studentDTO = StudentQualificationsDTO.builder()
                        .idStudent(q.getIdStudent())
                        .fullNameStudent(q.getFullNameStudent())
                        .qualifications(newArrayList(qualification))
                        .build();

                dtoList.add(studentDTO);
            }
        }
        return dtoList;
    }
}
