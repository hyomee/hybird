package com.hyomee.demo.elastic.connector;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import com.hyomee.core.elastic.utils.QueryBuilderUtils;
import com.hyomee.demo.elastic.dto.DemoDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ESClientConnectorTest {


    @Autowired
    ESClientConnector esClientConnector;
    @Test
    void prepareQueryList() {

        DemoDTO demoDTO = DemoDTO.builder()
                .uuid("0189fd217a74741cb5d5041eda890575")
                .title("데모 타이들 1")
                .description("면적 69.49㎢, 인구 39만 5625명(2001)이다. 북쪽으로는 수정구와 중원구, 동쪽으로는 광주시, 남쪽으로는 용인시, 서쪽으로는 의왕시에 접한다. 이 지역을 가로질러 북류하는 탄천 주변의 평야지대를 제외하고는 대체로 산지로 뒤덮여 있다.")
                .build();

        List<Query> queryList =  QueryBuilderUtils.prepareQueryList(demoDTO );
        log.debug("Class to Map : \n " + queryList.toString());
    }

    @Test
    void insertDemo() {
    }

    @Test
    void retrieveDemoDTOById() {
    }

    @Test
    void retrieveDemoDTOWithMustQuery() throws IOException {
        DemoDTO demoDTO = DemoDTO.builder()
                // .uuid("0189fd217a74741cb5d5041eda890575")
                .title("데모 타이들 1")
                .build();

        List<DemoDTO> queryList =  esClientConnector.retrieveDemoDTOWithMustQuery(demoDTO );
        log.debug("Class to Map : \n " + queryList.toString());
    }

    @Test
    void retrieveDemoDTOWithShouldQuery() throws IOException {
        DemoDTO demoDTO = DemoDTO.builder()
                // .uuid("0189fd217a74741cb5d5041eda890575")
                .title("데모")
                .build();

        List<DemoDTO> queryList =  esClientConnector.retrieveDemoDTOWithShouldQuery(demoDTO );
        log.debug("Class to Map : \n " + queryList.toString());
    }

    @Test
    void retrieveDemoDTOWithShouldMatchQuery() throws IOException {
        DemoDTO demoDTO = DemoDTO.builder()
                // .uuid("0189fd217a74741cb5d5041eda890575")
                .title("데모")
                .build();

        List<DemoDTO> queryList =  esClientConnector.retrieveDemoDTOWithShouldMatchQuery(demoDTO );
        log.debug("Class to Map : \n " + queryList.toString());
    }

    @Test
    void deleteDemoDTOById() {
    }

    @Test
    void updateDemoDTO() {
    }
}