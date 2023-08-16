package com.hyomee.demo.elastic.connector;

import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.*;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.hyomee.core.elastic.config.ElasticSearchConfig;
import com.hyomee.core.elastic.utils.QueryBuilderUtils;
import com.hyomee.demo.elastic.dto.DemoDTO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ESClientConnector {

    @Value("${doc.demoIndex}")
    private String indexName;

    private final ElasticSearchConfig elasticSearchConfig;

    @SneakyThrows
    public String insertDemo(DemoDTO demoDTO )  {
        IndexRequest<DemoDTO> request = IndexRequest.of(i->
                i.index(indexName)
                        .id(demoDTO.getUuid())
                        .document(demoDTO));
        IndexResponse response = elasticSearchConfig.getElasticSearchClient().index(request);
        return response.result().toString();
    }

    @SneakyThrows
    public DemoDTO retrieveDemoDTOById(String id)   {
        GetResponse<DemoDTO> response = elasticSearchConfig.getElasticSearchClient().get(req->
                req.index(indexName)
                        .id(id), DemoDTO.class);

        if(!response.found())
           return DemoDTO.builder().build();

        return response.source();
    }



    public List<DemoDTO> retrieveDemoDTOWithMustQuery(DemoDTO demoDTO) throws IOException {
        List<Query> queries = QueryBuilderUtils.prepareQueryList(demoDTO );
        SearchResponse<DemoDTO> employeeSearchResponse = elasticSearchConfig.getElasticSearchClient().search(req->
                        req.index(indexName)
                                .size(demoDTO.getSize())
                                .query(query->
                                        query.bool(bool->
                                                bool.must(queries))),
                DemoDTO.class);

        return employeeSearchResponse.hits().hits().stream()
                .map(Hit::source).collect(Collectors.toList());
    }

    public List<DemoDTO> retrieveDemoDTOWithShouldMatchQuery(DemoDTO demoDTO) throws IOException {

        List<Query> queries = QueryBuilderUtils.matchQueryList(demoDTO );
        SearchResponse<DemoDTO> demoDTOSearchResponse = elasticSearchConfig.getElasticSearchClient().search(req->
                        req.index(indexName)
                                .size(demoDTO.getSize())
                                .query(query->
                                        query.bool(bool->
                                                bool.should(queries))),
                DemoDTO.class);

        return demoDTOSearchResponse.hits().hits().stream()
                .map(Hit::source).collect(Collectors.toList());
    }

    public List<DemoDTO> retrieveDemoDTOWithShouldQuery(DemoDTO demoDTO) throws IOException {

        List<Query> queries = QueryBuilderUtils.prepareQueryList(demoDTO );
        SearchResponse<DemoDTO> demoDTOSearchResponse = elasticSearchConfig.getElasticSearchClient().search(req->
                        req.index(indexName)
                                .size(demoDTO.getSize())
                                .query(query->
                                        query.bool(bool->
                                                bool.should(queries))),
                DemoDTO.class);

        return demoDTOSearchResponse.hits().hits().stream()
                .map(Hit::source).collect(Collectors.toList());
    }

    public String deleteDemoDTOById(Long id) throws IOException {
        DeleteRequest request = DeleteRequest.of(req->
                req.index(indexName).id(String.valueOf(id)));
        DeleteResponse response = elasticSearchConfig.getElasticSearchClient().delete(request);
        return response.result().toString();
    }

    public String updateDemoDTO(DemoDTO demoDTO) throws IOException {
        UpdateRequest<DemoDTO, DemoDTO> updateRequest = UpdateRequest.of(req->
                req.index(indexName)
                        .id(demoDTO.getUuid())
                        .doc(demoDTO));
        UpdateResponse<DemoDTO> response = elasticSearchConfig.getElasticSearchClient().update(updateRequest, DemoDTO.class);
        return response.result().toString();
    }


}
