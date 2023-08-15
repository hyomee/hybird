package com.hyomee.hybird.mybatis.demo.service;

import com.hyomee.demo.mybatis.dto.DemoDTO;
import com.hyomee.demo.mybatis.service.MybatisDemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class MybatisDemoServiceTest {

  @Autowired
  MybatisDemoService mybatisDemoService;

  @Disabled
  @Test
  void retrieveDemo() {
    List<DemoDTO> demoDTOs = mybatisDemoService.retrieveDemo();
    log.debug(demoDTOs.toString());
  }
}