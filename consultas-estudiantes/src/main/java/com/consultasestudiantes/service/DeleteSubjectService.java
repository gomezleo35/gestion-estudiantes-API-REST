package com.consultasestudiantes.service;

import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;

import java.util.List;

public interface DeleteSubjectService {

    List<EnrolledSubject>deleteSubject (DeleteSubjectDTO deleteSubjectDTO);
}
