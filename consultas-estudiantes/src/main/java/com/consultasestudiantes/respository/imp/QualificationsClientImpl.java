package com.consultasestudiantes.respository.imp;

import com.consultasestudiantes.mapper.ObtainQualificationsMapper;
import com.consultasestudiantes.model.Qualification;
import com.consultasestudiantes.respository.QualificationsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationsClientImpl implements QualificationsClient {

    private final ObtainQualificationsMapper qualificationsMapper;

    @Autowired
    public QualificationsClientImpl(ObtainQualificationsMapper qualificationsMapper) {
        this.qualificationsMapper = qualificationsMapper;
    }

    @Override
    public List<Qualification> obtainQualifications(Integer studentId) {
        return qualificationsMapper.obtainQualifications(studentId);
    }
}
