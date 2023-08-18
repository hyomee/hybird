package com.hyomee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.hyomee.demo.jpa.*")
@EnableElasticsearchRepositories(basePackages = "com.hyomee.demo.es.*")
@ComponentScan(basePackages = {"com.hyomee.*"})
@SpringBootApplication
public class HybirdApplication {  public static void main(String[] args) {
    SpringApplication.run(HybirdApplication.class, args);
  }

}
