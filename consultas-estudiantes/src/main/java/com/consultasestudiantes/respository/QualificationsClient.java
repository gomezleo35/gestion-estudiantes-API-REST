package com.consultasestudiantes.respository;

import com.consultasestudiantes.model.Qualification;

import java.util.List;

public interface QualificationsClient {
    List<Qualification> obtainQualifications (String studentId);
}
