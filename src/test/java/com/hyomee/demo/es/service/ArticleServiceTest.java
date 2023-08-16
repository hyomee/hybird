package com.hyomee.demo.es.service;

import com.hyomee.demo.es.doc.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ArticleServiceTest {

  @Autowired
  ArticleService articleService;
  @Test
  void save() {
    articleService.save();
  }
}