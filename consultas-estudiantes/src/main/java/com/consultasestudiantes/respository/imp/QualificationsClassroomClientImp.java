package com.consultasestudiantes.respository.imp;

import com.consultasestudiantes.mapper.ObtainQualificationClassroomMapper;
import com.consultasestudiantes.model.dto.QualificationClassroomDTO;
import com.consultasestudiantes.respository.QualificationsClassroomClient;

import java.util.List;

public class QualificationsClassroomClientImp implements QualificationsClassroomClient {

    private final ObtainQualificationClassroomMapper obtainQualificationClassroomMapper;

    public QualificationsClassroomClientImp(ObtainQualificationClassroomMapper obtainQualificationClassroomMapper) {
        this.obtainQualificationClassroomMapper = obtainQualificationClassroomMapper;
    }

    @Override
    public List<QualificationClassroomDTO> obtainQualificationsClassroom(Integer idClassroom) {
        return obtainQualificationClassroomMapper.obtainQualificationsClassroom(idClassroom);
    }
}
