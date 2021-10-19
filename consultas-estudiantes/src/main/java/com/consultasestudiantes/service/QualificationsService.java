package com.consultasestudiantes.service;

import com.consultasestudiantes.model.Subject;

import java.util.List;

public interface QualificationsService {
    List<Subject> obtainQualifications (Integer studentId);
}
