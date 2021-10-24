package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DeleteRequestAdapter implements Function<DeleteSubjectRequest, DeleteSubjectDTO> {
    @Override
    public DeleteSubjectDTO apply(DeleteSubjectRequest request) {
        return DeleteSubjectDTO.builder()
                .idStudent(request.getIdStudent())
                .idSubject(request.getIdSubject())
                .build();
    }
}
