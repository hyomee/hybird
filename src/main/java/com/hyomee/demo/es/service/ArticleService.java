package com.hyomee.demo.es.service;

import com.hyomee.demo.es.doc.Article;
import com.hyomee.demo.es.dto.ArticleDTO;
import com.hyomee.demo.es.repository.ArticleMapper;
import com.hyomee.demo.es.repository.ArticleRespository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@Service
public class ArticleService {

  private final ArticleRespository articleRespository;

  public void save(ArticleDTO articleDTO) {
    Article article = ArticleMapper.INSTANCE.toArticle(articleDTO);
    articleRespository.save(article);
  }

  public void saveAll(List<Article> articles) {
    articleRespository.saveAll(articles);
  }

  public List<ArticleDTO> retrieveArticleaAll() {
    Iterable<Article> articles = articleRespository.findAll();
    List<ArticleDTO> articleList = ArticleMapper.INSTANCE.toArticleList(articles);
    return articleList;
  }

  public void delete(String id) {
    Article article = Article.builder().id(id).build();
    articleRespository.delete(article);
  }

  public  ArticleDTO  retrieveArticle(String id) {
    Optional<Article> articleOptional = articleRespository.findById(id);
    if (articleOptional.isEmpty()) {
      return ArticleDTO.builder().build();
    }
    return ArticleMapper.INSTANCE.toArticleDTO(articleOptional.get());
  }

  public List<ArticleDTO> findByTitleContains(String title) {
    Iterable<Article> articles = articleRespository.findByTitleContains(title);
    List<ArticleDTO> articleList = ArticleMapper.INSTANCE.toArticleList(articles);
    return articleList;
  }

  public List<ArticleDTO> findByTitleLike(String title) {
    return articleRespository.findByTitleLike(title);
  }

  public Iterable<Article> findByTitleStartsWith(String title) {
    return articleRespository.findByTitleStartsWith(title);
  }

  public List<ArticleDTO> findByTitleEndsWith(String title) {
    return articleRespository.findByTitleEndsWith(title);
  }
}


