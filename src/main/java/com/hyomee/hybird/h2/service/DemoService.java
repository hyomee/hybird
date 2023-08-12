package com.hyomee.hybird.h2.service;

import com.hyomee.hybird.h2.dto.DemoDTO;
import com.hyomee.hybird.h2.entity.DemoEntity;
import com.hyomee.hybird.h2.repository.DemoMapper;
import com.hyomee.hybird.h2.repository.DemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DemoService {

  private final DemoRepository demoRepository;

  public List<DemoDTO> retrieveDemo() {
    List<DemoEntity> demoEntities = demoRepository.findAll();
    return DemoMapper.INSTANCE.toDemoEntirys(demoEntities);
  }
}
