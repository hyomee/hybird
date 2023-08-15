package com.hyomee.demo.mybatis.mapper;

import com.hyomee.demo.mybatis.dto.DemoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisDemoMapper {
  List<DemoDTO> retrieveDemo();

}
