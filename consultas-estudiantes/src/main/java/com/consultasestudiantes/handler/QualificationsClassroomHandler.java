package com.consultasestudiantes.handler;

import com.consultasestudiantes.model.http.QualificationClassroomRequest;
import com.consultasestudiantes.model.http.QualificationsClassroomResponse;

public interface QualificationsClassroomHandler {

    QualificationsClassroomResponse handleQualificationsClassroom (QualificationClassroomRequest request);
}
