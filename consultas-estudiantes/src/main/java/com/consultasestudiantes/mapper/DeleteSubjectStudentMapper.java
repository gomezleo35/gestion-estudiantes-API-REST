package com.consultasestudiantes.mapper;

import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeleteSubjectStudentMapper {

    void deleteSubjectStudent(@Param("deleteSubjectDTO") DeleteSubjectDTO deleteSubjectDTO);
}
