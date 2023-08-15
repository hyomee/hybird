package com.hyomee.es.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ElasticSearchConfigTest {

    @Autowired
    ElasticSearchConfig elasticSearchConfig;

    @Test
    void getElasticSearchClient() throws IOException {
        RestClient elClient = elasticSearchConfig.restClient();
        Request request = new Request(
                "GET",
                "/");
        Response response = elClient.performRequest(request);
        log.debug(response.getEntity().getContent().toString());
    }
}