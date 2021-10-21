package com.consultasestudiantes.controller;

import com.consultasestudiantes.model.Classroom;
import com.consultasestudiantes.model.Subject;
import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.model.http.*;
import com.consultasestudiantes.service.DeleteSubjectService;
import com.consultasestudiantes.service.QualificationsClassroomService;
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
    private final QualificationsClassroomService qualificationsClassroomService;
    private final DeleteSubjectService deleteSubjectService;

    public ObtainQualificationsController(QualificationsService qualificationsService, QualificationsClassroomService qualificationsClassroomService, DeleteSubjectService deleteSubjectService) {
        this.qualificationsService = qualificationsService;
        this.qualificationsClassroomService = qualificationsClassroomService;
        this.deleteSubjectService = deleteSubjectService;
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

    @PostMapping(value = "/classroom/id")
    @ApiOperation("Obtener notas y promedio de un curso")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = ClassroomResponse.class),
            @ApiResponse(code = 400, message = "Parametros mal ingresados", response = ClassroomResponse.class),
            @ApiResponse(code = 500, message = "Fallo interno", response = ClassroomResponse.class)})

    public Object obtainQualificationsClassroom (@RequestBody QualificationClassroomRequest request){

        Classroom classroom = qualificationsClassroomService.obtainClassroom(request.getIdClassroom());
        return  ResponseEntity.ok(ClassroomResponse.builder().classroom(classroom).build());
    }

    @PostMapping(value = "/subject")
    @ApiOperation("Eliminar materia de un estudiante")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK", response = QualificationsResponse.class),
            @ApiResponse(code = 400, message = "Parametros mal ingresados", response = QualificationsResponse.class),
            @ApiResponse(code = 500, message = "Fallo interno", response = QualificationsResponse.class)})


    public Object deleteSubject (@RequestBody DeleteSubjectDTO request) {
        List<EnrolledSubject> enrolledSubjects = deleteSubjectService.deleteSubject(request);
        return ResponseEntity.ok(SubjectsListResponse.builder()
                .enrolledSubjectList(enrolledSubjects).build());
    }
}
