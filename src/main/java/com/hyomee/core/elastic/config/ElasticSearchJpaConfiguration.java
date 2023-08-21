package com.hyomee.core.elastic.config;



import co.elastic.clients.transport.TransportUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.net.ssl.SSLContext;

@Configuration
public class ElasticSearchJpaConfiguration extends ElasticsearchConfiguration {

  @Value("${es.host}")
  private String host;

  @Value("${es.port:9200}")
  private String port;


  @Value("${es.username:elastic}")
  private String username;

  @Value("${es.password}")
  private String password;

  @Value("${es.fingerprint}")
  private String fingerprint;


  @Override
  public ClientConfiguration clientConfiguration() {
    SSLContext sslContext = TransportUtils.sslContextFromCaFingerprint(fingerprint);
    ClientConfiguration clientConfiguration = ClientConfiguration.builder() //
            .connectedTo(host + ":" + port)
            .usingSsl(sslContext)
            .withBasicAuth(username, password)
            // .withSocketTimeout(15000)
            .build();


    return clientConfiguration;
  }


//  @Override
//  public RestHighLevelClient elasticsearchClient() {
//    // SSLContext sslContext = TransportUtils.sslContextFromCaFingerprint(fingerprint);
//
//    ClientConfiguration clientConfiguration = ClientConfiguration.builder()
//            .connectedTo(host + ":" + port)
//            // .usingSsl(sslContext)
//            .withBasicAuth(username,password )
//            .build();
//
//    return RestClients.create(clientConfiguration).rest();
//  }
}



