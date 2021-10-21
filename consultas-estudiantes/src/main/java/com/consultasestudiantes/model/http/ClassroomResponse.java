package com.consultasestudiantes.model.http;

import com.consultasestudiantes.model.Classroom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ClassroomResponse {

    private Classroom classroom;
    private String errorMessage;
}
