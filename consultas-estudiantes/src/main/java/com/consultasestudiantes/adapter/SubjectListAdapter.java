package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.dto.SubjectDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.consultasestudiantes.utils.ObtainAverage.obtainAverage;

@Component
public class SubjectListAdapter implements Function<List<SubjectDTO>, List<Subject>> {


    @Override
    public List<Subject> apply(List<SubjectDTO> dtoList) {

        List<Subject> subjectsAverage = new ArrayList<>();

        for (SubjectDTO s : dtoList){
            subjectsAverage.add(obtainSubject(s));
        }
        return subjectsAverage;
    }

    public Subject obtainSubject(SubjectDTO dto) {

        return Subject.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .average(obtainAverage(dto.getGrades()))
                .build();
    }

}
