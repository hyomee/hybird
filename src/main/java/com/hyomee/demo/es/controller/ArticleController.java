package com.hyomee.demo.es.controller;

import com.hyomee.core.elastic.dto.ResponsePageDTO;
import com.hyomee.core.utils.ResponseUtils;
import com.hyomee.demo.es.doc.Article;
import com.hyomee.demo.es.dto.ArticleDTO;
import com.hyomee.demo.es.repository.ArticleRespository;
import com.hyomee.demo.es.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/es/")
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("v1")
    public void save(@RequestBody ArticleDTO articleDTO) {
        articleService.save(articleDTO);
    }

    @DeleteMapping("v1/{id}")
    public void delete(@PathVariable String id) {
        articleService.delete(id);
    }

    @PostMapping("v1/multi")
    public void saveAll(@RequestBody List<Article> articles) {
        articleService.saveAll(articles);
    }

    @GetMapping("v1")
    public ResponseEntity retrieveArticleaAll() {
        return ResponseUtils.completed(articleService.retrieveArticleaAll());
    }

    @GetMapping("v1/{id}")
    public  ResponseEntity  retrieveArticle(@PathVariable String id) {
        return  ResponseUtils.completed(articleService.retrieveArticle(id));
    }

    @GetMapping("v1/title/contains/{title}")
    public ResponseEntity findByTitleContains(@PathVariable String title) {
        ResponsePageDTO responsePageDTO = articleService.findByTitleContains(title);
        return ResponseUtils.completed(responsePageDTO);
    }

    @GetMapping("v1/title/like/{title}")
    public ResponseEntity findByTitleLike(@PathVariable String title,
                                          Pageable pageable) {

        List<Sort.Order> sorts = pageable.getSort().toList();
//        for (Sort.Order sort : sorts ) {
//            sort.getProperty() + ".koworld"
//        }
        return ResponseUtils.completed(articleService.findByTitleLike(title, pageable));
    }

    @GetMapping("v1/title/startswith/{title}")
    public ResponseEntity findByTitleStartsWith(@PathVariable String title) {
        return ResponseUtils.completed(articleService.findByTitleStartsWith(title));
    }

    @GetMapping("v1/title/endswith/{title}")
    public ResponseEntity findByTitleEndsWith(@PathVariable String title) {
        return ResponseUtils.completed(articleService.findByTitleEndsWith(title));
    }

}
