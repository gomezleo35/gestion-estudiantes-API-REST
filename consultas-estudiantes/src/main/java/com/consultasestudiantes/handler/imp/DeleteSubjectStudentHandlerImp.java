package com.consultasestudiantes.handler.imp;

import com.consultasestudiantes.adapter.DeleteRequestAdapter;
import com.consultasestudiantes.adapter.SubjectListResponseAdapter;
import com.consultasestudiantes.handler.DeleteSubjectStudentHandler;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import com.consultasestudiantes.model.http.SubjectsListResponse;
import com.consultasestudiantes.service.DeleteSubjectService;
import com.consultasestudiantes.validator.DeleteSubjectRequestValidator;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeleteSubjectStudentHandlerImp implements DeleteSubjectStudentHandler {

    private final DeleteSubjectService deleteSubjectService;
    private final DeleteSubjectRequestValidator deleteSubjectRequestValidator;
    private final Function<DeleteSubjectRequest, DeleteSubjectDTO> deleteRequestAdapter;
    private final SubjectListResponseAdapter subjectListResponseAdapter;

    public DeleteSubjectStudentHandlerImp(DeleteSubjectService deleteSubjectService,
                                          DeleteSubjectRequestValidator deleteSubjectRequestValidator,
                                          DeleteRequestAdapter deleteRequestAdapter,
                                          SubjectListResponseAdapter subjectListResponseAdapter) {
        this.deleteSubjectService = deleteSubjectService;
        this.deleteSubjectRequestValidator = deleteSubjectRequestValidator;
        this.deleteRequestAdapter = deleteRequestAdapter;
        this.subjectListResponseAdapter = subjectListResponseAdapter;
    }


    @Override
    public SubjectsListResponse handleDeleteSubjectStudent(DeleteSubjectRequest deleteSubjectRequest) {

        deleteSubjectRequestValidator.validate(deleteSubjectRequest);

        return subjectListResponseAdapter.apply(deleteSubjectService.deleteSubject(deleteRequestAdapter.apply(deleteSubjectRequest)));
    }
}
