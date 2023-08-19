package com.hyomee.hybird.message.controller;

import com.hyomee.demo.jpa.dto.DemoDTO;
import com.hyomee.hybird.message.service.MessageTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("messageTest/")
public class MessageTestController {

    private final MessageTestService messageTestService;
    @GetMapping("{msgCd}")
    public String getTestMessage(@PathVariable String msgCd) {
        return messageTestService.getTestMessage( msgCd);
    }

    @GetMapping("/biz/{msgCd}")
    public String getBizExption(@PathVariable String msgCd) {
        return messageTestService.getBizExption( msgCd);
    }


    @GetMapping(value = "/demoException")
    public List<DemoDTO> getDemoException(DemoDTO demoDTO) {
        return messageTestService.retrieveDemoException();
    }

    @GetMapping(value = "/demoNoException")
    public List<DemoDTO> retrieveDemoNoCodeException(DemoDTO demoDTO) {
        return messageTestService.retrieveDemoNoCodeException();
    }

    @GetMapping(value = "/demoArrayException")
    public List<DemoDTO> retrieveDemoArrayException(DemoDTO demoDTO) {
        return messageTestService.retrieveDemoArrayException();
    }

    @GetMapping(value = "/demoNoFormetException")
    public List<DemoDTO> retrieveDemoNoCodeFormatException(DemoDTO demoDTO) {
        return messageTestService.retrieveDemoNoCodeFormatException();
    }



}
