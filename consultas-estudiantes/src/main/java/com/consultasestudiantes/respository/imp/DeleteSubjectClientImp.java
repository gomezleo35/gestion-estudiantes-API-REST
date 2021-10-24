package com.consultasestudiantes.respository.imp;

import com.consultasestudiantes.mapper.DeleteSubjectStudentMapper;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import com.consultasestudiantes.respository.DeleteSubjectClient;
import org.springframework.stereotype.Service;

@Service
public class DeleteSubjectClientImp implements DeleteSubjectClient {

    private final DeleteSubjectStudentMapper deleteSubjectStudentMapper;

    public DeleteSubjectClientImp(DeleteSubjectStudentMapper deleteSubjectStudentMapper) {
        this.deleteSubjectStudentMapper = deleteSubjectStudentMapper;
    }

    @Override
    public void deleteSubject(DeleteSubjectDTO deleteSubjectDTO) {
        deleteSubjectStudentMapper.deleteSubjectStudent(deleteSubjectDTO);
    }
}
