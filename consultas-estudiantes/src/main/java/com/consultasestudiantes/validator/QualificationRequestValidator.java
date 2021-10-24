package com.consultasestudiantes.validator;

import com.consultasestudiantes.model.http.QualificationsRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class QualificationRequestValidator implements Validator<QualificationsRequest>{

    @Override
    public void validate(QualificationsRequest request){
        Assert.notNull(request, "request");
        Assert.isTrue(StringUtils.isNumeric(request.getStudentId()), "idStudent");
    }
}
