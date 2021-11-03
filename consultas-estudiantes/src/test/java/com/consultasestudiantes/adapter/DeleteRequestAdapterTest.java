package com.consultasestudiantes.adapter;

import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DeleteRequestAdapterTest {

    @Test
    @DisplayName("Should return dto model correctly")
    public void should_return_dto_model_correctly() {
        DeleteRequestAdapter adapter = new DeleteRequestAdapter();
        final String idStudent = "1";
        final String idSubject = "2";
        final DeleteSubjectRequest request = DeleteSubjectRequest.builder()
                .idStudent(idStudent)
                .idSubject(idSubject)
                .build();

        final DeleteSubjectDTO expectedDTO = adapter.apply(request);

        assertThat(expectedDTO.getIdStudent(), is(idStudent));
        assertThat(expectedDTO.getIdSubject(), is(idSubject));
    }
}
