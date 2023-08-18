package com.hyomee.demo.es.repository;

import com.hyomee.demo.es.doc.Article;
import com.hyomee.demo.es.dto.ArticleDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;



import java.util.List;


@Repository
public interface ArticleRespository  extends ElasticsearchRepository<Article, String> {
    List<ArticleDTO> findByTitle(String title);

    Page<Article> findByTitleContains(String title, Pageable pageable);

    Page<Article>  findByTitleLike(String title, Pageable pageable);

    Iterable<Article> findByTitleStartsWith(String title);

    Iterable<Article> findByTitleEndsWith(String title);

}
