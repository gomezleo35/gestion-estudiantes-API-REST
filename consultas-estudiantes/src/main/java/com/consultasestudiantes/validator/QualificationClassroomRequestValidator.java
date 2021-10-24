package com.consultasestudiantes.validator;

import com.consultasestudiantes.model.http.QualificationClassroomRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class QualificationClassroomRequestValidator implements Validator<QualificationClassroomRequest>{

    @Override
    public void validate(QualificationClassroomRequest request) {
        Assert.notNull(request, "request");
        Assert.isTrue(StringUtils.isNumeric(request.getIdClassroom()), "idClassroom");
    }
}
