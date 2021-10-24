package com.consultasestudiantes.handler;

import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import com.consultasestudiantes.model.http.SubjectsListResponse;

public interface DeleteSubjectStudentHandler {

    SubjectsListResponse handleDeleteSubjectStudent (DeleteSubjectRequest deleteSubjectRequest);
}
