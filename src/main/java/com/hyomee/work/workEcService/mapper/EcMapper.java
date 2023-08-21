package com.hyomee.work.workEcService.mapper;

import com.hyomee.work.workEcService.doc.TourListDoc;
import com.hyomee.work.workEcService.dto.TourListEcDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EcMapper {

    EcMapper INSTANCE = Mappers.getMapper(EcMapper.class);

    List<TourListDoc> toTourListDOCs(List<TourListEcDTO> tourListEcDTOs) ;
}
