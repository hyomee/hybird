package com.hyomee.demo.es.service;

import com.hyomee.core.elastic.dto.PageDTO;
import com.hyomee.core.elastic.dto.ResponsePageDTO;
import com.hyomee.core.jpa.utils.PageUtils;
import com.hyomee.demo.es.doc.Article;
import com.hyomee.demo.es.dto.ArticleDTO;
import com.hyomee.demo.es.repository.ArticleMapper;
import com.hyomee.demo.es.repository.ArticleRespository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
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

  public ResponsePageDTO findByTitleContains(String title) {

    Page<Article> articles = articleRespository.findByTitleContains(title,
            PageUtils.getPageable());

    ResponsePageDTO responsePageDTO = ResponsePageDTO.setResponsePageDTO(articles);

    // List<ArticleDTO> articleList = ArticleMapper.INSTANCE.toArticleList(articles);
    return responsePageDTO;
  }

  public ResponsePageDTO findByTitleLike(String title, Pageable pageable) {

    Page<Article> articles = articleRespository.findByTitleLike(title, pageable);

    ResponsePageDTO responsePageDTO = ResponsePageDTO.setResponsePageDTO(articles);

    return responsePageDTO;
  }

  public List<ArticleDTO> findByTitleStartsWith(String title) {
    Iterable<Article>  articles = articleRespository.findByTitleStartsWith(title);
    List<ArticleDTO> articleList = ArticleMapper.INSTANCE.toArticleList(articles);
    return articleList;
  }

  public List<ArticleDTO> findByTitleEndsWith(String title) {
    return ArticleMapper.INSTANCE.toArticleList(articleRespository.findByTitleEndsWith(title));
  }
}


