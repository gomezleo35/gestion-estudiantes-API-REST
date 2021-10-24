package com.consultasestudiantes.respository.imp;

import com.consultasestudiantes.mapper.ObtainQualificationClassroomMapper;
import com.consultasestudiantes.model.dto.QualificationClassroomDTO;
import com.consultasestudiantes.respository.QualificationsClassroomClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationsClassroomClientImp implements QualificationsClassroomClient {

    private final ObtainQualificationClassroomMapper obtainQualificationClassroomMapper;

    @Autowired
    public QualificationsClassroomClientImp(ObtainQualificationClassroomMapper obtainQualificationClassroomMapper) {
        this.obtainQualificationClassroomMapper = obtainQualificationClassroomMapper;
    }

    @Override
    public List<QualificationClassroomDTO> obtainQualificationsClassroom(String idClassroom) {
        return obtainQualificationClassroomMapper.obtainQualificationsClassroom(idClassroom);
    }
}
