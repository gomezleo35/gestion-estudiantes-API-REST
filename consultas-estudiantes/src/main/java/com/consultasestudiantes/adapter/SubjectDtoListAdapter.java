package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.model.dto.SubjectDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static com.google.common.collect.Lists.newArrayList;

@Component
    public class SubjectDtoListAdapter implements Function<List<Qualification>, List<SubjectDTO>> {

    @Override
    public List<SubjectDTO> apply(List<Qualification> qualifications) {

        List<SubjectDTO> dtoList = new ArrayList<>();

        for (Qualification q : qualifications){
            Integer subjectId = 0;
            if(dtoList.size() > 0){
                for (SubjectDTO dto : dtoList){
                    if (dto.getId()  == q.getIdSubject()){
                        dto.getGrades().add(q.getQualification());
                        subjectId = dto.getId();
                        break;
                    }
                }
            }

            if(subjectId == 0){
                dtoList.add(SubjectDTO.builder()
                        .id(q.getIdSubject())
                        .grades(newArrayList(q.getQualification()))
                        .description(q.getDescription())
                        .build());
            }
        }
        return dtoList;
    }
}