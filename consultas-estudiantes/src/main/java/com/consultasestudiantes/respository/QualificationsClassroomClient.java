package com.consultasestudiantes.respository;

import com.consultasestudiantes.model.dto.QualificationClassroomDTO;

import java.util.List;

public interface QualificationsClassroomClient {

    List<QualificationClassroomDTO> obtainQualificationsClassroom(Integer idClassroom);
}
