package com.hyomee.hybird.message.service;

import com.hyomee.core.config.message.MessageUTIL;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MessageTestServiceTest {

  @Autowired
  MessageTestService messageTestService;
  @Disabled
  @Test
  void getTestMessage() {
    log.debug(messageTestService.getTestMessage("ERR_0000"));
    log.debug(messageTestService.getTestMessage("KOREA"));
  }
}