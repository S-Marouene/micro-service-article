package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Article;
import com.sip.ams.models.ArticleProvider;
import com.sip.ams.services.ArticleService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/articles")
@Slf4j

@CrossOrigin("*")

public class ArticleController {
	@Autowired
	ArticleService articleService;

	@PostMapping("/")
	public Article saveArticle(@RequestBody Article article) {
		log.info("Ajout d'article avec succès depuis Article Controller");
		return articleService.savaArticle(article);

	}

	@GetMapping("/{id}")
	public ArticleProvider getArticleWithProvider(@PathVariable("id") Long articleId) {
		log.info("Get article avec son provider depuis Article Controller");
		return articleService.getArticleWithProvider(articleId);
	}
	
	/*@GetMapping("/all")
	public List<Article> getAllArticle(){
		log.info("article test Log Info");
		
		return articleService.findAllArticle();
	}*/
	
	@GetMapping("/all")
	public List<ArticleProvider> getAllArticle(){
	
		return articleService.getAllArticleWithProvider();
	}
	
	
}
