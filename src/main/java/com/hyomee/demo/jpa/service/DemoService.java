package com.hyomee.demo.jpa.service;

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
    return DemoMapper.INSTANCE.toDemoDTOs(demoEntities);
  }


  public DemoDTO saveDemo(DemoDTO demoDTO ) {
    DemoEntity demoEntity = DemoMapper.INSTANCE.toDemoEntitys(demoDTO);
    DemoEntity demoEntitySave = demoRepository.save(demoEntity);
    return DemoMapper.INSTANCE.toDemoDTO(demoEntitySave);
  }

}
