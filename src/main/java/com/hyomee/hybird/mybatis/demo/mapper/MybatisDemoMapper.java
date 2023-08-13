package com.hyomee.hybird.mybatis.demo.mapper;

import com.hyomee.hybird.mybatis.demo.dto.DemoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisDemoMapper {
  List<DemoDTO> retrieveDemo();

}
