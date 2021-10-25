package com.consultasestudiantes.controller;

import com.consultasestudiantes.handler.QualificationsHandler;
import com.consultasestudiantes.model.http.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("Controlador para obtener el promedio general de cada una de las materias de un estudiante")
public class ObtainQualificationsController {

    private final Logger logger = LoggerFactory.getLogger(ObtainQualificationsController.class);

    private static final String REQUEST_MESSAGE = "Request notas de un curso, student: {}";
    private static final String BAD_REQUEST_MESSAGE = "Los campos son obligatorios o invalidos, o no estan presente: {}";
    private static final String UNKNOWN_ERROR_MESSAGE = "Ocurrio un error desconocido al intentar cambiar el pin: {}";

    private final QualificationsHandler qualificationsHandler;

    public ObtainQualificationsController(QualificationsHandler qualificationsHandler) {
        this.qualificationsHandler = qualificationsHandler;
    }

    @PostMapping(value = "/students/id")
    @ApiOperation("obtener informacion del estudiante por ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = QualificationsResponse.class),
            @ApiResponse(code = 400, message = "Parametros mal ingresados", response = QualificationsResponse.class),
            @ApiResponse(code = 500, message = "Fallo interno", response = QualificationsResponse.class)})

    public ResponseEntity<QualificationsResponse> obtainQualifications (@RequestBody QualificationsRequest request ){
        try {
            logger.info(REQUEST_MESSAGE,request.getStudentId());
            return ResponseEntity.ok(qualificationsHandler.handleQualificationsStudent(request));

        } catch (IllegalArgumentException iae) {
            logger.warn(BAD_REQUEST_MESSAGE, iae, iae.getMessage());

            return ResponseEntity.badRequest().body(QualificationsResponse.builder().errorMessage(iae.getMessage()).build());
        } catch (Exception ex) {
            logger.error(UNKNOWN_ERROR_MESSAGE, request.getStudentId());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                QualificationsResponse.builder().errorMessage(ex.getMessage()).build()
            );
        }

    }


}
