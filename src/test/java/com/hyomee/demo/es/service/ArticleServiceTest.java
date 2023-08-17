package com.hyomee.demo.es.service;

import com.google.gson.Gson;
import com.hyomee.demo.es.doc.Article;
import com.hyomee.demo.es.dto.ArticleDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ArticleServiceTest {

  @Autowired
  ArticleService articleService;

  @Autowired
  Gson gson;

  @Test
  void save() {
       articleService.save(ArticleDTO.builder().title("JPA 예제4").contents("JPA 예제 JPA 예제 JPA 예제2 12567").build());
  }


  @Test
  void saveAll() {
    List<Article> articles = List.of(Article.builder().title("JPA 예제3").contents("JPA 예제 JPA 예제 JPA 예제2 1234").build(),
            Article.builder().title("JPA 예제4").contents("JPA 예제 JPA 예제 JPA 예제2 12567").build(),
            Article.builder().title("JPA 예제5").contents("JPA 예제 JPA 예제 JPA 예제2 12345").build(),
            Article.builder().title("MyBatis 예제1").contents("MyBatis 예제 MyBatis 예제 MyBatis 예제1 3456").build(),
            Article.builder().title("MyBatis 예제2").contents("MyBatis 예제 MyBatis 예제 MyBatis 예제2 3467").build(),
            Article.builder().title("MyBatis 예제2").contents("MyBatis 예제 MyBatis 예제 MyBatis 예제3 6784").build(),
            Article.builder().title("MyBatis 예제2").contents("MyBatis 예제 MyBatis 예제 MyBatis 예제4 4232").build()
    );
    articleService.saveAll(articles);
  }


  @Test
  void retrieveArticleaAll() {
    List<ArticleDTO> articles = articleService.retrieveArticleaAll();
    log.debug("articles : \n" + gson.toJson(articles));

    String title = "예제";
     ;
    log.debug("articles findByTitleContains : \n" +  gson.toJson(articleService.findByTitleContains(title)));
    log.debug("articles findByTitleLike : \n" +  gson.toJson(articleService.findByTitleLike(title)));
    log.debug("articles findByTitleStartsWith : \n" +  gson.toJson(articleService.findByTitleStartsWith(title)));
    log.debug("articles findByTitleEndsWith: \n" +  gson.toJson(articleService.findByTitleEndsWith(title)));

  }

  @Test
  void retrieveArticle() {
    ArticleDTO articleDTO = articleService.retrieveArticle("IaXZAYoBHIzlGk-V7IKu");
    log.debug("articles : \n" + gson.toJson(articleDTO));

  }
}

