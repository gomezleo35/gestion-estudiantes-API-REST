package com.consultasestudiantes.service.imp;

import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.dto.SubjectDTO;
import com.consultasestudiantes.respository.QualificationsClient;
import com.consultasestudiantes.service.QualificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class QualificationsServiceImp implements QualificationsService {

    private final QualificationsClient qualificationsClient;
    private final Function<List<Qualification>, List<SubjectDTO>> subjectDtoListAdapter;
    private final Function<List<SubjectDTO>, List<Subject>> subjectListAdapter;

    @Autowired
    public QualificationsServiceImp(QualificationsClient qualificationsClient,
                                    Function<List<Qualification>, List<SubjectDTO>> subjectDtoListAdapter,
                                    Function<List<SubjectDTO>, List<Subject>> subjectListAdapter) {
        this.qualificationsClient = qualificationsClient;
        this.subjectDtoListAdapter = subjectDtoListAdapter;
        this.subjectListAdapter = subjectListAdapter;
    }

    @Override
    public List<Subject> obtainQualifications(Integer studentId) {

        return subjectListAdapter.apply(
                subjectDtoListAdapter.apply(qualificationsClient.obtainQualifications(studentId))
        );
    }
}
