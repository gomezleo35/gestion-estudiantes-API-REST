package com.consultasestudiantes.validator;

import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class DeleteSubjectRequestValidator implements Validator<DeleteSubjectRequest>{
    @Override
    public void validate(DeleteSubjectRequest request) {
        Assert.notNull(request, "request");
        Assert.isTrue(StringUtils.isNumeric(request.getIdSubject()),"idSubject");
        Assert.isTrue(StringUtils.isNumeric(request.getIdStudent()),"idSubject");
    }
}
