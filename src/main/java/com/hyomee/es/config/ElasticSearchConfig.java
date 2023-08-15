package com.hyomee.es.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.TransportUtils;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.message.BasicHeader;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.IOException;

// @Configuration
@Getter
@Setter
@Slf4j
@Component
public class ElasticSearchConfig {


    @Value("${es.host}")
    private String host;

    @Value("${es.port}")
    private String port;

    @Value("${es.schemeName}")
    private String schemeName;

    @Value("${es.username}")
    private String username;

    @Value("${es.password}")
    private String password;

    @Value("${es.fingerprint}")
    private String fingerprint;

    @Value("${es.ssl:false}")
    private String ssl;

    @Value("${es.cadrt:false}")
    private String cadrt;



    @Bean
    public ElasticsearchClient getElasticSearchClient() throws IOException {
        // https://www.elastic.co/guide/en/elasticsearch/client/java-api-client/current/connecting.html
   // https://github.com/sundharamurali/elasticsearch-springboot/tree/main

        // Create the low-level client
        RestClient restClient = restClient();
        // Create the transport with a Jackson mapper
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());

        // And create the API client
        return new ElasticsearchClient(transport);
    }

    public void elasticsearchUtlInfo() {
        log.debug("Host: " +  host);
        log.debug("Port: " +  port);
        log.debug("SchemeName: " +  schemeName);
        log.debug("username: " +   username);
        log.debug("fingerprint: " +  fingerprint);
        log.debug("ssl: " +  ssl);
        log.debug("cadrt: " +  cadrt);
    }

    public RestClient restClient() throws IOException {
        elasticsearchUtlInfo();
        if ("1".equals(ssl))  {
            return getRestSSLClient();
        } else if ("2".equals(ssl))  {
            return getRestSSLClient();
        } else {
            return getRestCaClient();
        }
    }


    public  RestClient getRestPwdClient() {
        log.debug("#### getRestPwdClient");
//        Header[] defaultHeaders = new Header[1];
//        defaultHeaders[0] = new BasicHeader("Authorization", "Basic ZWxhc3RpYzo9ZHEyWEt0cF9wMkRGXzJRaUx5cw==");

        final BasicCredentialsProvider hasicCredentialsProvider = new BasicCredentialsProvider();

        hasicCredentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(username, password));

        RestClient restClient = RestClient.builder(new HttpHost(host, Integer.parseInt(port), schemeName))
                .setHttpClientConfigCallback(httpClientBuilder ->
                        httpClientBuilder.setDefaultCredentialsProvider(hasicCredentialsProvider))

                .build();

        return restClient;
    }

    public  RestClient getRestSSLClient() {

        log.debug("#### getRestSSLClient");
        SSLContext sslContext = TransportUtils.sslContextFromCaFingerprint(fingerprint);


        BasicCredentialsProvider credsProv = new BasicCredentialsProvider();
        credsProv.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(username, password)
        );

        RestClient restClient = RestClient
                .builder(new HttpHost(host, Integer.parseInt(port), schemeName)) // <3>
                .setHttpClientConfigCallback(hc -> hc
                        .setSSLContext(sslContext) // <4>
                        .setDefaultCredentialsProvider(credsProv)
                )
                .build();

        // Create the low-level client
        return restClient;
    }

    public  RestClient getRestCaClient() throws IOException {
        log.debug("#### getRestCaClient");
        File certFile = new File(String.valueOf(cadrt));
        SSLContext sslContext = TransportUtils.sslContextFromHttpCaCrt(certFile);


        BasicCredentialsProvider credsProv = new BasicCredentialsProvider();
        credsProv.setCredentials(
                AuthScope.ANY,
                new UsernamePasswordCredentials(username, password)
        );

        RestClient restClient = RestClient
                .builder(new HttpHost(host, Integer.parseInt(port), schemeName)) // <3>
                .setHttpClientConfigCallback(hc -> hc
                        .setSSLContext(sslContext) // <4>
                        .setDefaultCredentialsProvider(credsProv)
                )
                .build();

        // Create the low-level client
        return restClient;
    }

}
