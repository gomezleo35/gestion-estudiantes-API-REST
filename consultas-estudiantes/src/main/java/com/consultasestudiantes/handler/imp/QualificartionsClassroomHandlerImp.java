package com.consultasestudiantes.handler.imp;

import com.consultasestudiantes.handler.QualificationsClassroomHandler;
import com.consultasestudiantes.model.Classroom;
import com.consultasestudiantes.model.http.QualificationClassroomRequest;
import com.consultasestudiantes.model.http.QualificationsClassroomResponse;
import com.consultasestudiantes.service.QualificationsClassroomService;
import com.consultasestudiantes.validator.QualificationClassroomRequestValidator;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class QualificartionsClassroomHandlerImp implements QualificationsClassroomHandler {

    private final QualificationsClassroomService qualificationsClassroomService;
    private final QualificationClassroomRequestValidator qualificationClassroomRequestValidator;
    private final Function<Classroom, QualificationsClassroomResponse> qualificationsClassroomResponseAdapter;

    public QualificartionsClassroomHandlerImp(QualificationsClassroomService qualificationsClassroomService,
                                              QualificationClassroomRequestValidator qualificationClassroomRequestValidator, Function<Classroom, QualificationsClassroomResponse> qualificationsClassroomResponseAdapter) {
        this.qualificationsClassroomService = qualificationsClassroomService;
        this.qualificationClassroomRequestValidator = qualificationClassroomRequestValidator;
        this.qualificationsClassroomResponseAdapter = qualificationsClassroomResponseAdapter;
    }


    @Override
    public QualificationsClassroomResponse handleQualificationsClassroom(QualificationClassroomRequest request) {

        qualificationClassroomRequestValidator.validate(request);

        return qualificationsClassroomResponseAdapter
                .apply(qualificationsClassroomService.obtainClassroom(
                        request.getIdClassroom()
                        )
                );
    }
}
