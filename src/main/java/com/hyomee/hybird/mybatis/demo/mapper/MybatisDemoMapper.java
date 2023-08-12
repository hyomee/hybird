package com.hyomee.hybird.mybatis.demo.mapper;

import com.hyomee.hybird.mybatis.demo.dto.DemoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Component
@Mapper
public interface MybatisDemoMapper {
  List<DemoDTO> retrieveDemo();

}
