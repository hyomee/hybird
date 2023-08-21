package com.hyomee.work.workService.repository;

import com.hyomee.work.workEcService.dto.TourListEcDTO;
import com.hyomee.work.workService.dto.TourlistDTO;
import com.hyomee.work.workService.entity.TourlistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WorkMapper {
  WorkMapper INSTANCE = Mappers.getMapper(WorkMapper.class);

  TourlistDTO toTourlistDTO(TourlistEntity tourlistEntity);
  List<TourlistDTO> toTourlistDTOs(List<TourlistEntity> tourlistEntity);

  TourlistEntity toTourlistEntity(TourlistDTO tourlistDTO);
  List<TourlistEntity> toTourlistEntitys(List<TourlistDTO> tourlistDTO);

}
