package com.hyomee.es.config;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@Slf4j
@SpringBootTest
class ElasticSearchConfigTest {

    @Autowired
    ElasticSearchConfig elasticSearchConfig;

    @Disabled
    @Test
    void getElasticSearchClient() throws IOException {
        RestClient elClient = elasticSearchConfig.getRestClient();
        Request request = new Request(
                "GET",
                "/");
        Response response = elClient.performRequest(request);
        log.debug(response.getEntity().getContent().toString());
    }
}