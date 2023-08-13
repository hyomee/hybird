package com.hyomee.hybird.h2.controller;

import com.hyomee.core.utils.ResponseUtils;
import com.hyomee.hybird.h2.dto.DemoDTO;
import com.hyomee.hybird.h2.service.DemoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class DemoController {

  private final DemoService demoService;

  @GetMapping(value = "/demoEntity")
  public ResponseEntity getDemoEntity(DemoDTO demoDTO) {
    List<DemoDTO> demoDTOs = demoService.retrieveDemo();
    return ResponseUtils.completed(demoDTOs);
  }

  @GetMapping(value = "/demo")
  public List<DemoDTO> getDemo(DemoDTO demoDTO) {
    return demoService.retrieveDemo();
  }

  @GetMapping(value = "/demoException")
  public List<DemoDTO> getDemoException(DemoDTO demoDTO) {
    return demoService.retrieveDemoException();
  }

  @GetMapping(value = "/demoNoException")
  public List<DemoDTO> retrieveDemoNoCodeException(DemoDTO demoDTO) {
    return demoService.retrieveDemoNoCodeException();
  }

  @GetMapping(value = "/demoArrayException")
  public List<DemoDTO> retrieveDemoArrayException(DemoDTO demoDTO) {
    return demoService.retrieveDemoArrayException();
  }

  @GetMapping(value = "/demoNoFormetException")
  public List<DemoDTO> retrieveDemoNoCodeFormatException(DemoDTO demoDTO) {
    return demoService.retrieveDemoNoCodeFormatException();
  }


}
