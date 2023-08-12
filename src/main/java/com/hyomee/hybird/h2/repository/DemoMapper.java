package com.hyomee.hybird.h2.repository;

import com.hyomee.hybird.h2.dto.DemoDTO;
import com.hyomee.hybird.h2.entity.DemoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DemoMapper {
  DemoMapper INSTANCE = Mappers.getMapper(DemoMapper.class);

  List<DemoDTO> toDemoEntirys(List<DemoEntity> demoEntities);

}
