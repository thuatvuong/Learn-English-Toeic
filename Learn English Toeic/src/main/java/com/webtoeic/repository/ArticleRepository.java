package com.webtoeic.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webtoeic.entities.Article;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

    Optional<Article> findArticleByUrl(String url);

    List<Article> findArticleById(Long id);

    @Override
    Page<Article> findAll(Pageable pageable);
}
