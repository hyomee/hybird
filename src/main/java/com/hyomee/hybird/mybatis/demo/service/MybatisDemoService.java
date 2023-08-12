package com.hyomee.hybird.mybatis.demo.service;

import com.hyomee.hybird.mybatis.demo.dto.DemoDTO;
import com.hyomee.hybird.mybatis.demo.mapper.MybatisDemoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MybatisDemoService {
  private final MybatisDemoMapper mybatisDemoMapper;

  public List<DemoDTO> retrieveDemo() {
    return mybatisDemoMapper.retrieveDemo();
  }
}
