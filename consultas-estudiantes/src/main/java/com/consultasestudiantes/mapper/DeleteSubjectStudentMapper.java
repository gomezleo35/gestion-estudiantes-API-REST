package com.consultasestudiantes.mapper;

import com.consultasestudiantes.model.dto.DeleteSubjectDTO;
import com.consultasestudiantes.model.http.DeleteSubjectRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeleteSubjectStudentMapper {

    void deleteSubjectStudent(@Param("deleteSubject") DeleteSubjectDTO deleteSubjectDTO);
}
