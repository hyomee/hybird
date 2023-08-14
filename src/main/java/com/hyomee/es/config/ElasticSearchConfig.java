package com.hyomee.es.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
@Setter
public class ElasticSearchConfig {


  @Value("${es.uris}")
  private String urls;

  @Value("${es.port}")
  private String port;

  @Value("${es.schemeName}")
  private String schemeName;
  @Value("${es.username}")
  private String username;

  @Value("${es.password}")
  private String password;

  @Bean
  public ElasticsearchClient getElasticSearchClient() {
    // https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/connecting.html
// https://github.com/sundharamurali/elasticsearch-springboot/tree/main
    final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
    credentialsProvider.setCredentials(AuthScope.ANY,
            new UsernamePasswordCredentials(username, password));

    RestClientBuilder builder = RestClient.builder(new HttpHost(urls, Integer.parseInt(port), schemeName))
            .setHttpClientConfigCallback(httpClientBuilder ->
                    httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider));

    // Create the low-level client
//    RestClient restClient = RestClient
//            .builder(HttpHost.create(serverUrl))
//            .setDefaultHeaders(new Header[]{
//                    new BasicAttributes("Authorization", "ApiKey " + apiKey)
//            })
//            .build();

    // Create the low-level client
    RestClient restClient = builder.build();

    // Create the transport with a Jackson mapper
    ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

    // And create the API client
    return new ElasticsearchClient(transport);
  }
}
