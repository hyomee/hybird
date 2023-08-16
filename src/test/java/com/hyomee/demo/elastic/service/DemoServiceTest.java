package com.hyomee.demo.elastic.service;

import com.hyomee.demo.elastic.dto.DemoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
class DemoServiceTest {

    @Autowired
    ESDemoService esDemoService;
    @Test
    void insertDemo() {
        DemoDTO demoDTO = DemoDTO.builder()
                .title("데모 타이들 2")
                .description("면적 69.49㎢, 인구 39만 5625명(2001)이다. 북쪽으로는 수정구와 중원구, 동쪽으로는 광주시, 남쪽으로는 용인시, 서쪽으로는 의왕시에 접한다. 이 지역을 가로질러 북류하는 탄천 주변의 평야지대를 제외하고는 대체로 산지로 뒤덮여 있다.")
                .build();
        String response = esDemoService.insertDemo(demoDTO);
        log.debug("Response :: " + response);
    }

    @Test
    void fetchDemoDTOById() {

        DemoDTO demoDTO = esDemoService.fetchDemoDTOById("0189fd217a74741cb5d5041eda890575");
        log.debug("Response :: " + demoDTO.toString());
    }

}