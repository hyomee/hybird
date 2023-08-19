package com.hyomee.hybird.message.service;

import com.hyomee.core.config.message.MessageUTIL;
import com.hyomee.core.customException.BizException;
import com.hyomee.demo.jpa.dto.DemoDTO;
import com.hyomee.demo.jpa.entity.DemoEntity;
import com.hyomee.demo.jpa.repository.DemoMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageTestService {

  public String getTestMessage(String msgCd) {
    return MessageUTIL.getMessage(msgCd);
  }


  public String getBizExption(String msgCd) {
    if (true) throw new BizException("뭐지 오류네,,,,,,,");
    return "정상"  + msgCd;
  }


  public List<DemoDTO> retrieveDemoException() {
    if (true) throw new BizException("ERR_0002");
    return new ArrayList<>();
  }

  public List<DemoDTO> retrieveDemoNoCodeException() {
    if (true) throw new BizException("헉 이건 뭐지 글자 그대로 오류 발생 .....");
    return new ArrayList<>();
  }

  public List<DemoDTO> retrieveDemoArrayException() {
    if (true) throw new BizException("ERR_0003", "오류1", "오류2");
    return new ArrayList<>();
  }

  public List<DemoDTO> retrieveDemoNoCodeFormatException() {
    if (true) throw new BizException("헉 이건 뭐지 글자 {0} 그대로 오류 발생 {1}.....", "포맷터1", "포맷터2");
    return new ArrayList<>();
  }
}
