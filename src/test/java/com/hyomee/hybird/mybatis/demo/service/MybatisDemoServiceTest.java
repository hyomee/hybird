package com.hyomee.hybird.mybatis.demo.service;

import com.hyomee.hybird.mybatis.demo.dto.DemoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MybatisDemoServiceTest {

  @Autowired
  MybatisDemoService mybatisDemoService;

  @Test
  void retrieveDemo() {
    List<DemoDTO> demoDTOs = mybatisDemoService.retrieveDemo();
    System.out.println(demoDTOs.toString());
  }
}