package com.webtoeic.api.client;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webtoeic.entities.Article;
import com.webtoeic.service.ArticleService;

@RestController
@RequestMapping("/api/client/bai-bao")
public class ArticleControllerApi {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/allArticles")
    public ResponseEntity<Page<Article>> getAllArticles(@RequestParam(defaultValue = "1") int page) {

        return new ResponseEntity<>(articleService.getAllArticles(page - 1  , 4), HttpStatus.OK);
    }

    @GetMapping("/article/{id}")
    public  ResponseEntity<Article> getAritcle(@PathVariable("id") Long id) {

        Optional<Article> article = articleService.getArticle(id);

        return article.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

}
