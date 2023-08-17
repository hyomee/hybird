package com.hyomee.demo.es.repository;

import com.hyomee.demo.es.doc.Article;
import com.hyomee.demo.es.dto.ArticleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class) ;

    Article toArticle(ArticleDTO articleDTO);
    ArticleDTO toArticleDTO(Article articles);
    List<ArticleDTO> toArticleList(Iterable<Article> articles);


}
