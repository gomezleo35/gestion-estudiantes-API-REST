package com.consultasestudiantes.respository.imp;

import com.consultasestudiantes.mapper.ObtainQualificationClassroomMapper;
import com.consultasestudiantes.model.dto.QualificationClassroomDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;


class QualificationsClassroomClientImpTest {

    @Mock
    private ObtainQualificationClassroomMapper mockObtainQualificationClassroomMapper;

    private QualificationsClassroomClientImp sut;

    @BeforeEach
    private void setUp(){
        initMocks(this);
        sut = new QualificationsClassroomClientImp(mockObtainQualificationClassroomMapper);
    }

    @Test
    public void should_returns_list_correctly_when_obtainQualificationsClassroom_is_success (){
        String idClassroom = "1";

        List<QualificationClassroomDTO> qualificationClassroomDTOList = new ArrayList<>();

        qualificationClassroomDTOList.add(QualificationClassroomDTO.builder()
                .idStudent(1)
                .idSubject(1)
                .description("Matematicas")
                .nameClassroom("1A")
                .fullNameStudent("leo")
                .qualification(5.0)
                .build());

        qualificationClassroomDTOList.add(QualificationClassroomDTO.builder()
                .idStudent(1)
                .idSubject(1)
                .description("Matematicas")
                .nameClassroom("1A")
                .fullNameStudent("leo")
                .qualification(6.0)
                .build());

        qualificationClassroomDTOList.add(QualificationClassroomDTO.builder()
                .idStudent(1)
                .idSubject(2)
                .description("Fisica")
                .nameClassroom("1A")
                .fullNameStudent("leo")
                .qualification(5.0)
                .build());

        qualificationClassroomDTOList.add(QualificationClassroomDTO.builder()
                .idStudent(1)
                .idSubject(2)
                .description("Fisica")
                .nameClassroom("1A")
                .fullNameStudent("leo")
                .qualification(6.0)
                .build());

        qualificationClassroomDTOList.add(QualificationClassroomDTO.builder()
                .idStudent(2)
                .idSubject(1)
                .description("Matematicas")
                .nameClassroom("1A")
                .fullNameStudent("gabi")
                .qualification(7.0)
                .build());

        qualificationClassroomDTOList.add(QualificationClassroomDTO.builder()
                .idStudent(2)
                .idSubject(1)
                .description("Matematicas")
                .nameClassroom("1A")
                .fullNameStudent("gabi")
                .qualification(6.0)
                .build());

        qualificationClassroomDTOList.add(QualificationClassroomDTO.builder()
                .idStudent(2)
                .idSubject(2)
                .description("Fisica")
                .nameClassroom("1A")
                .fullNameStudent("gabi")
                .qualification(5.0)
                .build());

        qualificationClassroomDTOList.add(QualificationClassroomDTO.builder()
                .idStudent(2)
                .idSubject(2)
                .description("Fisica")
                .nameClassroom("1A")
                .fullNameStudent("gabi")
                .qualification(6.0)
                .build());

        when(mockObtainQualificationClassroomMapper.obtainQualificationsClassroom(idClassroom))
                .thenReturn(qualificationClassroomDTOList);

        List<QualificationClassroomDTO> actualQualificationClassroomDTOList = sut.obtainQualificationsClassroom(idClassroom);

        assertThat(actualQualificationClassroomDTOList.get(0).getIdStudent(),
                is(qualificationClassroomDTOList.get(0).getIdStudent()));
        assertThat(actualQualificationClassroomDTOList.get(0).getIdSubject(),
                is(qualificationClassroomDTOList.get(0).getIdSubject()));
        assertThat(actualQualificationClassroomDTOList.get(0).getQualification(),
                is(qualificationClassroomDTOList.get(0).getQualification()));
        assertThat(actualQualificationClassroomDTOList.get(0).getNameClassroom(),
                is(qualificationClassroomDTOList.get(0).getNameClassroom()));
        assertThat(actualQualificationClassroomDTOList.get(0).getFullNameStudent(),
                is(qualificationClassroomDTOList.get(0).getFullNameStudent()));
        assertThat(actualQualificationClassroomDTOList.get(0).getDescription(),
                is(qualificationClassroomDTOList.get(0).getDescription()));
    }

}