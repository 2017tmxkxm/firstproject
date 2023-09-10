package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> index() {
        return articleRepository.findAll();
    }

    public Article show(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article create(ArticleForm form) {
        Article articleEntity = form.toEntity();
        if(articleEntity.getId() != null) {
            return null;
        }
        return articleRepository.save(articleEntity);
    }

    public Article update(Long id, ArticleForm form) {
        Article articleEntity = form.toEntity();
        log.info("id : {}, article : {}", id, articleEntity.toString());

        Article target = articleRepository.findById(id).orElse(null);

        if(target == null || id != articleEntity.getId()) {
            log.info("잘못된 요청 id : {}, articleEntity : {}", id, articleEntity.toString());
            return null;
        }

        target.patch(articleEntity);
        Article updated = articleRepository.save(target);

        return updated;
    }

    public Article delete(Long id) {
        Article target = articleRepository.findById(id).orElse(null);

        if(target == null) {
            return null;
        }

        articleRepository.delete(target);
        return target;
    }

    @Transactional
    public List<Article> createArticles(List<ArticleForm> dtos) {
        List<Article> articleList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());

        articleList.stream()
                .forEach(article -> articleRepository.save(article));

        articleRepository.findById(-1L)
                .orElseThrow(() -> new IllegalArgumentException("등록 실패"));

        return articleList;
    }
}
