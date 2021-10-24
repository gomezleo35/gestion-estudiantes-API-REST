package com.consultasestudiantes.service.imp;

import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import com.consultasestudiantes.respository.DeleteSubjectClient;
import com.consultasestudiantes.respository.ListSubjectClient;
import com.consultasestudiantes.service.DeleteSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteSubjectServiceImp implements DeleteSubjectService {

    private final DeleteSubjectClient deleteSubjectClient;
    private final ListSubjectClient listSubjectClient;

    @Autowired
    public DeleteSubjectServiceImp(DeleteSubjectClient deleteSubjectClient,
                                   ListSubjectClient listSubjectClient) {
        this.deleteSubjectClient = deleteSubjectClient;
        this.listSubjectClient = listSubjectClient;
    }

    @Override
    public List<EnrolledSubject> deleteSubject(DeleteSubjectDTO deleteSubjectDTO) {

        deleteSubjectClient.deleteSubject(deleteSubjectDTO);

        return listSubjectClient.obtainSubjects(deleteSubjectDTO);
    }
}
