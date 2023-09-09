package com.example.firstproject.api;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.experimental.PackagePrivate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class ArticleApiController {
    @Autowired
    private final ArticleRepository articleRepository;


    public ArticleApiController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @GetMapping("/api/articles/{id}")
    public Article index(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm form) {
        Article articleEntity = form.toEntity();
        return articleRepository.save(articleEntity);
    }

    @PatchMapping("/api/articles/{id}")
    public ResponseEntity<Article> update(@PathVariable Long id, @RequestBody ArticleForm form) {
        Article articleEntity = form.toEntity();
        Article target = articleRepository.findById(articleEntity.getId()).orElse(null);

        if(target == null || id != articleEntity.getId()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        target.patch(articleEntity);
        Article updated = articleRepository.save((target));

        return ResponseEntity.status(HttpStatus.OK).body(updated);
    }

    @DeleteMapping("/api/articles/{id}")
    public ResponseEntity<Article> delete(@PathVariable Long id) {
        Article target = articleRepository.findById(id).orElse(null);

        if(target == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        articleRepository.delete(target);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
