package com.consultasestudiantes.handler;

import com.consultasestudiantes.model.http.QualificationsRequest;
import com.consultasestudiantes.model.http.QualificationsResponse;

public interface QualificationsHandler {

    QualificationsResponse handleQualificationsStudent (QualificationsRequest request);
}
