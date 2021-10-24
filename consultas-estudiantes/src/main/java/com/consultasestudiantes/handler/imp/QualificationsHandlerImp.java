package com.consultasestudiantes.handler.imp;

import com.consultasestudiantes.handler.QualificationsHandler;
import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.http.QualificationsRequest;
import com.consultasestudiantes.model.http.QualificationsResponse;
import com.consultasestudiantes.service.QualificationsService;
import com.consultasestudiantes.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class QualificationsHandlerImp implements QualificationsHandler {

    private final Validator<QualificationsRequest> validator;
    private final QualificationsService qualificationsService;
    private final Function<List<Subject>, QualificationsResponse> qualificationsResponseAdapter;


    @Autowired
    public QualificationsHandlerImp(QualificationsService qualificationsService, Function<List<Subject>, QualificationsResponse> qualificationsResponseAdapter, Validator<QualificationsRequest> validator) {
        this.qualificationsService = qualificationsService;
        this.qualificationsResponseAdapter = qualificationsResponseAdapter;
        this.validator = validator;
    }

    @Override
    public QualificationsResponse handleQualificationsStudent(QualificationsRequest request){

        validator.validate(request);

        return qualificationsResponseAdapter.apply(
                qualificationsService.obtainQualifications(request.getStudentId())
        );
    }
}
