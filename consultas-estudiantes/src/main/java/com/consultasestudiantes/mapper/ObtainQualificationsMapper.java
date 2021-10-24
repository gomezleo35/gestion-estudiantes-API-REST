package com.consultasestudiantes.mapper;

import com.consultasestudiantes.model.Qualification;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ObtainQualificationsMapper {

    List<Qualification> obtainQualifications (@Param("studentId") String studentId);
}
