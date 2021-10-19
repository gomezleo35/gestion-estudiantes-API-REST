package com.consultasestudiantes.controller;

import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.http.QualificationsRequest;
import com.consultasestudiantes.model.http.QualificationsResponse;
import com.consultasestudiantes.service.QualificationsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ObtainQualificationsController {

    private final QualificationsService qualificationsService;

    public ObtainQualificationsController(QualificationsService qualificationsService) {
        this.qualificationsService = qualificationsService;
    }


    @PostMapping(value = "/students/id")
    @ApiOperation("obtener informacion del estudiante por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = QualificationsResponse.class),                      //a partir de aca se crea el package http
            @ApiResponse(code = 400, message = "Parametros mal ingresados", response = QualificationsResponse.class),
            @ApiResponse(code = 500, message = "Fallo interno", response = QualificationsResponse.class)})

    public Object obtainQualifications (@RequestBody QualificationsRequest request ){

        List<Subject> subjects = qualificationsService.obtainQualifications(request.getStudentId());
        return  ResponseEntity.ok(QualificationsResponse.builder()
                .studentQualifications(subjects)
                .build());
    }

}
