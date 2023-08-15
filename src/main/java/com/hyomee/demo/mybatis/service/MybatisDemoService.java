package com.hyomee.demo.mybatis.service;

import com.hyomee.demo.mybatis.dto.DemoDTO;
import com.hyomee.demo.mybatis.mapper.MybatisDemoMapper;
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
