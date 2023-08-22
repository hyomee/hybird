package com.hyomee.demo.mock.controller;

import com.hyomee.core.utils.JsonFileReadUtils;
import com.hyomee.core.utils.ResponseUtils;
import com.hyomee.demo.mock.dto.MockDemoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/mock/")
public class MockTestController {

    @GetMapping("/getMockData")
    public <T> ResponseEntity getMockData() throws FileNotFoundException, UnsupportedEncodingException {
       T responseData =  JsonFileReadUtils.jsonLoading("demo\\getMockData", MockDemoDTO.class);
       return ResponseUtils.completed(responseData);
    }

}
