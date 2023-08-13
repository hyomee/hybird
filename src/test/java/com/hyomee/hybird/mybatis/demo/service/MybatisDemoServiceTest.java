package com.hyomee.hybird.mybatis.demo.service;

import com.hyomee.hybird.mybatis.demo.dto.DemoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class MybatisDemoServiceTest {

  @Autowired
  MybatisDemoService mybatisDemoService;

  @Test
  void retrieveDemo() {
    List<DemoDTO> demoDTOs = mybatisDemoService.retrieveDemo();
    log.debug(demoDTOs.toString());
  }
}