package com.consultasestudiantes.respository;

import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;

import java.util.List;

public interface ListSubjectClient {

    List<EnrolledSubject> obtainSubjects (DeleteSubjectDTO deleteSubjectDTO);
}
