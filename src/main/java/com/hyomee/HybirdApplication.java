package com.hyomee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling   // 스케줄링 기능활성화
@EnableJpaRepositories(basePackages = { "com.hyomee.core.jpa", "com.hyomee.demo.jpa", "com.hyomee.work.workService" })
@EnableElasticsearchRepositories(basePackages = { "com.hyomee.demo.es", "com.hyomee.work.workEcService" })
@SpringBootApplication
public class HybirdApplication {  public static void main(String[] args) {
    SpringApplication.run(HybirdApplication.class, args);
  }

}
