package com.hyomee.hybird.h2.service;

import com.hyomee.core.exception.BizException.BizException;
import com.hyomee.hybird.h2.dto.DemoDTO;
import com.hyomee.hybird.h2.entity.DemoEntity;
import com.hyomee.hybird.h2.repository.DemoMapper;
import com.hyomee.hybird.h2.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;

import java.util.List;
import java.util.Optional;

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
