package com.hyomee.demo.es.repository;

import com.hyomee.demo.es.doc.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleRespository  extends ElasticsearchRepository<Article, String> {
}
