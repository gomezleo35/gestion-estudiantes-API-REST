package com.consultasestudiantes.mapper;

import com.consultasestudiantes.model.EnrolledSubject;
import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ObtainSubjectsMapper {

    List<EnrolledSubject> obtainSubjects (@Param("deleteSubjectDTO") DeleteSubjectDTO deleteSubjectDTO);
}
