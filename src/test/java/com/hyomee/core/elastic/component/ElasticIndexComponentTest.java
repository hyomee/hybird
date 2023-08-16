package com.hyomee.core.elastic.component;

import com.hyomee.core.elastic.vo.ElasticIndexVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ElasticIndexComponentTest {

  @Autowired
  ElasticIndexComponent elasticIndexComponent;

  @Disabled
  @Test
  void createIndexRequest()  {
    ElasticIndexVO elasticIndexVO = ElasticIndexVO.builder()
            .indexName("demo")
            .build();

//    boolean isDeleteIndex = elasticIndexComponent.deleteIndex( elasticIndexVO );
//    log.debug("deleteIndex ==> " + isDeleteIndex);

    boolean isCreateIndex = elasticIndexComponent.createIndexRequest(elasticIndexVO);
    log.debug("createIndexRequest ==> " + isCreateIndex);
  }


}