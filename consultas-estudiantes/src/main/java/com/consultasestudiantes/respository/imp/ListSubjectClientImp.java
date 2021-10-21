package com.consultasestudiantes.respository.imp;

import com.consultasestudiantes.mapper.ObtainSubjectsMapper;
import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.respository.ListSubjectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListSubjectClientImp implements ListSubjectClient {

    private final ObtainSubjectsMapper obtainSubjectsMapper;

    @Autowired
    public ListSubjectClientImp(ObtainSubjectsMapper obtainSubjectsMapper) {
        this.obtainSubjectsMapper = obtainSubjectsMapper;
    }

    @Override
    public List<EnrolledSubject> obtainSubjects(DeleteSubjectDTO deleteSubjectDTO) {
        return obtainSubjectsMapper.obtainSubjects(deleteSubjectDTO);
    }
}
