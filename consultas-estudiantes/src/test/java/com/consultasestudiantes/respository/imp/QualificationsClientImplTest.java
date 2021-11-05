package com.consultasestudiantes.respository.imp;

import com.consultasestudiantes.mapper.ObtainQualificationsMapper;
import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.respository.QualificationsClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class QualificationsClientImplTest {

    @Mock
    private ObtainQualificationsMapper mockQualificationsMapper;

    private QualificationsClient sut;

    @BeforeEach
    public void setUp (){
        initMocks(this);
        sut = new QualificationsClientImpl(mockQualificationsMapper);
    }

    @Test
    public void should_returns_list_correctly_when_obtainQualifications_is_success (){
        String studentId = "1";
        List<Qualification> qualifications = new ArrayList<>();

        qualifications.add(Qualification.builder()
                .qualification(5.8)
                .idSubject(1)
                .description("química")
                .build());

        qualifications.add(Qualification.builder()
                .qualification(9.3)
                .idSubject(2)
                .description("matematicas")
                .build());

        when(mockQualificationsMapper.obtainQualifications(studentId)).thenReturn(qualifications);


        List<Qualification> actualQualificationList = sut.obtainQualifications(studentId);

        assertThat(actualQualificationList.get(0).getQualification(),is(qualifications.get(0).getQualification()));
    }

}