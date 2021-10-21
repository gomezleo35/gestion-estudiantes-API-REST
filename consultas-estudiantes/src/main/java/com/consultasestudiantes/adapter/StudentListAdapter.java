package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.model.Student;
import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.dto.StudentQualificationsDTO;
import com.consultasestudiantes.model.dto.SubjectDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.consultasestudiantes.utils.ObtainAverage.obtainAverage;

@Component
public class StudentListAdapter implements Function<List<StudentQualificationsDTO>, List<Student>> {

    private final Function<List<Qualification>, List<SubjectDTO>> subjectDtoListAdapter;
    private final Function<List<SubjectDTO>, List<Subject>> subjectListAdapter;

    public StudentListAdapter(Function<List<Qualification>, List<SubjectDTO>> subjectDtoListAdapter,
                              Function<List<SubjectDTO>, List<Subject>> subjectListAdapter) {
        this.subjectDtoListAdapter = subjectDtoListAdapter;
        this.subjectListAdapter = subjectListAdapter;
    }

    @Override
    public List<Student> apply(List<StudentQualificationsDTO> studentQualificationsDTOS) {

        List<Student> studentList = new ArrayList<>();

        for(StudentQualificationsDTO s : studentQualificationsDTOS ){
            List<SubjectDTO> subjectDTOS = subjectDtoListAdapter.apply(s.getQualifications());
            List<Subject> subjectList = subjectListAdapter.apply(subjectDTOS);
            List<Double> grades = new ArrayList<>();

            subjectList.stream().forEach(subject -> grades.add(subject.getAverage()));

            Double average = obtainAverage(grades);
            Student student = Student.builder()
                    .idStudent(s.getIdStudent())
                    .fullName(s.getFullNameStudent())
                    .subjectsStudent(subjectList)
                    .average(average)
                    .build();

            studentList.add(student);
        }

        return studentList;
    }
}
