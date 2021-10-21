package com.consultasestudiantes.mapper;

import com.consultasestudiantes.model.dto.QualificationClassroomDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ObtainQualificationClassroomMapper {
    List<QualificationClassroomDTO> obtainQualificationsClassroom (@Param("idClassroom") Integer idClassroom);
}
