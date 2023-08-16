package com.hyomee.demo.es.service;

import com.hyomee.demo.es.doc.Article;
import com.hyomee.demo.es.repository.ArticleRespository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class ArticleService {

  private final ArticleRespository articleRespository;

  public void save() {
    articleRespository.save(Article.builder()
                    .title("JPA 예제2")
                    .contents("JPA 예제 JPA 예제 JPA 예제2 222")
            .build());
  }
}


