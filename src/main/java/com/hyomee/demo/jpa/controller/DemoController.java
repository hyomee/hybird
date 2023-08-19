package com.hyomee.demo.jpa.controller;

import com.hyomee.core.utils.ResponseUtils;
import com.hyomee.demo.jpa.dto.DemoDTO;
import com.hyomee.demo.jpa.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/jpademo/")
public class DemoController {

  private final DemoService demoService;

  @GetMapping(value = "")
  public ResponseEntity getDemoEntity(DemoDTO demoDTO) {
    List<DemoDTO> demoDTOs = demoService.retrieveDemo();
    return ResponseUtils.completed(demoDTOs);
  }

  @GetMapping(value = "/obj")
  public List<DemoDTO> getDemo(DemoDTO demoDTO) {
    return demoService.retrieveDemo();
  }

  @PostMapping(value = "")
  public DemoDTO saveDemo(@RequestBody DemoDTO demoDTO) {
    return demoService.saveDemo(demoDTO);
  }
}
