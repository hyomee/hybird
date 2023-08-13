package com.hyomee.hybird.message.service;

import com.hyomee.core.config.message.MessageUTIL;
import org.springframework.stereotype.Service;

@Service
public class MessageTestService {

  public String getTestMessage(String msgCd) {
    return MessageUTIL.getMessage(msgCd);
  }
}
