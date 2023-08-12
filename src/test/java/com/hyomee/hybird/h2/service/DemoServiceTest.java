package com.hyomee.hybird.h2.service;

import com.hyomee.hybird.h2.dto.DemoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DemoServiceTest {

  @Autowired
  DemoService demoService;

  @Test
  void retrieveDemo() {
    List<DemoDTO> demoDTOs = demoService.retrieveDemo();
    System.out.println(demoDTOs.toString());
  }
}