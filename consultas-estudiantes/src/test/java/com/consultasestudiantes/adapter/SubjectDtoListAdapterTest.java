package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.model.dto.SubjectDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class SubjectDtoListAdapterTest {

    private SubjectDtoListAdapter sut = new SubjectDtoListAdapter();

    @Test
    public void should_return_subjectDto_correctly() {

        List<Qualification> qualifications = new ArrayList<>();

        qualifications.add(Qualification.builder()
                .idSubject(1)
                .qualification(8.5)
                .description("fisica")
                .build());

        qualifications.add(Qualification.builder()
                .idSubject(1)
                .qualification(3.5)
                .description("fisica")
                .build());

        qualifications.add(Qualification.builder()
                .idSubject(2)
                .qualification(7.5)
                .description("quimica")
                .build());

        qualifications.add(Qualification.builder()
                .idSubject(2)
                .qualification(6.5)
                .description("quimica")
                .build());



        List<SubjectDTO> actualSubjectDtoList = sut.apply(qualifications);

        assertThat(actualSubjectDtoList.get(0).getId(), is(qualifications.get(0).getIdSubject()));
        assertThat(actualSubjectDtoList.get(0).getId(), is(qualifications.get(1).getIdSubject()));
        assertThat(actualSubjectDtoList.get(0).getDescription(), is(qualifications.get(1).getDescription()));
        assertThat(actualSubjectDtoList.get(0).getGrades(),
                is(newArrayList(qualifications.get(0).getQualification(),qualifications.get(1).getQualification())));
        assertThat(actualSubjectDtoList.get(0).getDescription(),is(qualifications.get(0).getDescription()));

    }

}