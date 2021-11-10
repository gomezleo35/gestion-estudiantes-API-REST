package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.dto.SubjectDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SubjectListAdapterTest {

    @Test
    public void should_return_list_model_correctly(){

        SubjectListAdapter sut = new SubjectListAdapter();

        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        List<Double> grades = new ArrayList<>();
        List<Double> gradesTwo = new ArrayList<>();

        grades.add(1.5);
        grades.add(8.5);
        gradesTwo.add(5.5);
        gradesTwo.add(6.5);

        subjectDTOList.add(SubjectDTO.builder()
                .id(1)
                .description("matematicas")
                .grades(grades)
                .build());

        subjectDTOList.add(SubjectDTO.builder()
                .id(2)
                .description("Fisica")
                .grades(gradesTwo).build());

        List<Subject> actualSubjectList = sut.apply(subjectDTOList);

        assertThat(actualSubjectList.get(0).getId(), is(subjectDTOList.get(0).getId()));
        assertThat(actualSubjectList.get(0).getDescription(), is(subjectDTOList.get(0).getDescription()));
        assertThat(actualSubjectList.get(0).getAverage(),
                is((subjectDTOList.get(0).getGrades().get(0)+subjectDTOList.get(0).getGrades().get(1))/2));

    }


}