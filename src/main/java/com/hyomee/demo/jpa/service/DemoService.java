package com.hyomee.demo.jpa.service;

import com.hyomee.core.customException.BizException;
import com.hyomee.demo.jpa.dto.DemoDTO;
import com.hyomee.demo.jpa.repository.DemoMapper;
import com.hyomee.demo.jpa.entity.DemoEntity;
import com.hyomee.demo.jpa.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DemoService {

  private final DemoRepository demoRepository;

  public List<DemoDTO> retrieveDemo() {
    List<DemoEntity> demoEntities = demoRepository.findAll();
    log.debug(demoEntities.toString());
    return DemoMapper.INSTANCE.toDemoEntirys(demoEntities);
  }

  public List<DemoDTO> retrieveDemoException() {
    List<DemoEntity> demoEntities = demoRepository.findAll();
    if (true) throw new BizException("ERR_0002");
    return DemoMapper.INSTANCE.toDemoEntirys(demoEntities);
  }

  public List<DemoDTO> retrieveDemoNoCodeException() {
    List<DemoEntity> demoEntities = demoRepository.findAll();
    if (true) throw new BizException("헉 이건 뭐지 글자 그대로 오류 발생 .....");
    return DemoMapper.INSTANCE.toDemoEntirys(demoEntities);
  }

  public List<DemoDTO> retrieveDemoArrayException() {
    List<DemoEntity> demoEntities = demoRepository.findAll();
    if (true) throw new BizException("ERR_0003", "오류1", "오류2");
    return DemoMapper.INSTANCE.toDemoEntirys(demoEntities);
  }

  public List<DemoDTO> retrieveDemoNoCodeFormatException() {
    List<DemoEntity> demoEntities = demoRepository.findAll();
    if (true) throw new BizException("헉 이건 뭐지 글자 {0} 그대로 오류 발생 {1}.....", "포맷터1", "포맷터2");
    return DemoMapper.INSTANCE.toDemoEntirys(demoEntities);
  }
}
