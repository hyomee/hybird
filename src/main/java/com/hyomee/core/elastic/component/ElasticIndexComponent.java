package com.hyomee.core.elastic.component;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.Time;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import co.elastic.clients.elasticsearch.core.IndexResponse;
import co.elastic.clients.elasticsearch.indices.*;
import co.elastic.clients.json.JsonData;
import com.hyomee.core.common.constant.CommonConstant;
import com.hyomee.core.elastic.config.ElasticSearchConfig;
import com.hyomee.core.elastic.vo.ElasticIndexVO;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

@Slf4j
@RequiredArgsConstructor
@Component
public class ElasticIndexComponent {

  private final ElasticSearchConfig elasticSearchConfig;


  @SneakyThrows
  public boolean createIndexRequest(ElasticIndexVO elasticIndexVO )   {

    IndexSettings indexSettings = new IndexSettings.Builder()
            .numberOfShards(StringUtils.isEmpty(elasticIndexVO.getShards()) ? "1" : elasticIndexVO.getShards())
            .numberOfReplicas(StringUtils.isEmpty(elasticIndexVO.getReplicas()) ? "1" : elasticIndexVO.getReplicas())
            //.analysis()
            .refreshInterval(new Time.Builder()
                    .time(StringUtils.isEmpty(elasticIndexVO.getReplicas()) ? "5s" : elasticIndexVO.getRefreshInterval()  + "s")
                    .build())
            .build();

    String aliasName = elasticIndexVO.getIndexName() + "-Alias";

    ElasticsearchClient esClient = elasticSearchConfig.getElasticSearchClient();

    CreateIndexRequest createIndexRequest = new CreateIndexRequest.Builder()
            .index(elasticIndexVO.getIndexName())
            .aliases(aliasName, new Alias.Builder().isWriteIndex(false).build())
            .settings(indexSettings)
            .build();

    CreateIndexResponse createResponse = null;
    boolean isCreateIndex = CommonConstant.COMMON_FALSE;

    try {
      createResponse = esClient.indices().create(createIndexRequest);
      isCreateIndex = createResponse.acknowledged();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      esClient._transport().close();
    }

    return isCreateIndex;

  }

  @SneakyThrows
  public boolean deleteIndex(ElasticIndexVO elasticIndexVO ) {
    boolean isDeleteIndex = CommonConstant.COMMON_FALSE;
    ElasticsearchClient esClient = elasticSearchConfig.getElasticSearchClient();
    DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest.Builder().index(elasticIndexVO.getIndexName()).build();

    try {
      DeleteIndexResponse deleteResponse = esClient.indices().delete(deleteIndexRequest);
      isDeleteIndex =  deleteResponse.acknowledged();
    } catch (IOException e) {
      throw new RuntimeException(e);
    } finally {
      esClient._transport().close();
    }

    return isDeleteIndex;
  }
}
