package com.consultasestudiantes.controller;

import com.consultasestudiantes.handler.QualificationsClassroomHandler;
import com.consultasestudiantes.model.http.ClassroomResponse;
import com.consultasestudiantes.model.http.QualificationClassroomRequest;
import com.consultasestudiantes.model.http.QualificationsClassroomResponse;
import com.consultasestudiantes.model.http.QualificationsResponse;
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
@Api("Controlador para obtener el promedio general del curso y de cada estudiante")
public class ObtainQualificationsClassroomController {

    private final Logger logger = LoggerFactory.getLogger(ObtainQualificationsController.class);

    private static final String REQUEST_MESSAGE = "Request notas de alumno, student: {}";
    private static final String BAD_REQUEST_MESSAGE = "Los campos son obligatorios o invalidos, o no estan presente: {}";
    private static final String UNKNOWN_ERROR_MESSAGE = "Ocurrio un error desconocido al intentar cambiar el pin: {}";

    private final QualificationsClassroomHandler qualificationsClassroomHandler;

    public ObtainQualificationsClassroomController(QualificationsClassroomHandler qualificationsClassroomHandler) {
        this.qualificationsClassroomHandler = qualificationsClassroomHandler;
    }

    @PostMapping(value = "/classroom/id")
    @ApiOperation("Obtener notas y promedio de un curso")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = ClassroomResponse.class),
            @ApiResponse(code = 400, message = "Parametros mal ingresados", response = ClassroomResponse.class),
            @ApiResponse(code = 500, message = "Fallo interno", response = ClassroomResponse.class)})

    public ResponseEntity<QualificationsClassroomResponse> obtainQualificationsClassroom (@RequestBody QualificationClassroomRequest request){

        try {
            logger.info(REQUEST_MESSAGE,request.getIdClassroom());
            return ResponseEntity.ok(qualificationsClassroomHandler.handleQualificationsClassroom(request));

        } catch (IllegalArgumentException iae) {
            logger.warn(BAD_REQUEST_MESSAGE, iae, iae.getMessage());

            return ResponseEntity.badRequest().body(QualificationsClassroomResponse.builder().errorMessage(iae.getMessage()).build());
        } catch (Exception ex) {
            logger.error(UNKNOWN_ERROR_MESSAGE, request.getIdClassroom());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    QualificationsClassroomResponse.builder().errorMessage(ex.getMessage()).build()
            );
        }
    }

}
