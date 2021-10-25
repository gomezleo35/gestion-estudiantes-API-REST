package com.consultasestudiantes.controller;

import com.consultasestudiantes.handler.DeleteSubjectStudentHandler;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import com.consultasestudiantes.model.http.QualificationsResponse;
import com.consultasestudiantes.model.http.SubjectsListResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Controlador para eliminar materias de un estudiante activo")
public class DeleteSubjectStudentController {

    private final Logger logger = LoggerFactory.getLogger(ObtainQualificationsController.class);

    private static final String REQUEST_MESSAGE = "Request materia del alumno que desea eliminar, student: {}";
    private static final String BAD_REQUEST_MESSAGE = "Los campos son obligatorios o invalidos, o no estan presente: {}";
    private static final String UNKNOWN_ERROR_MESSAGE = "Ocurrio un error desconocido al intentar cambiar el pin: {}";

    private final DeleteSubjectStudentHandler deleteSubjectStudentHandler;

    public DeleteSubjectStudentController(DeleteSubjectStudentHandler deleteSubjectStudentHandler) {
        this.deleteSubjectStudentHandler = deleteSubjectStudentHandler;
    }

    @PostMapping(value = "/subject")
    @ApiOperation("Eliminar materia de un estudiante")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = QualificationsResponse.class),
            @ApiResponse(code = 400, message = "Parametros mal ingresados", response = QualificationsResponse.class),
            @ApiResponse(code = 500, message = "Fallo interno", response = QualificationsResponse.class)})


    public ResponseEntity<SubjectsListResponse> deleteSubject (@RequestBody DeleteSubjectRequest deleteSubjectRequest) {

        return ResponseEntity.ok(deleteSubjectStudentHandler.handleDeleteSubjectStudent(deleteSubjectRequest));
    }
}
