package com.sip.ams.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sip.ams.entities.Article;
import com.sip.ams.models.ArticleProvider;
import com.sip.ams.models.Provider;
import com.sip.ams.repositories.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j


public class ArticleService {
	
	@Autowired
	ArticleRepository articleRepositorty;
	@Autowired
	RestTemplate restTemplate;

	
	public Article savaArticle(Article article) {
		log.info("Ajout d'article avec succès depuis Article Service");
		return articleRepositorty.save(article);
	}
	
	public ArticleProvider getArticleWithProvider(Long articleId) {
		ArticleProvider article_provider = new ArticleProvider();
		log.info("Get article avec son provider succès depuis Article Service");
		Article article = articleRepositorty.findArticleById(articleId);

		Provider provider = restTemplate.getForObject("http://provider-service/providers/"+article.getProviderId(), Provider.class);
		
		article_provider.setArticle(article);
		article_provider.setProvider(provider);
		return article_provider;
	}
	
	
	
	
	public List<Article> findAllArticle() {
		return articleRepositorty.findAll();
	}
	
	public List<ArticleProvider> getAllArticleWithProvider() {
		List<ArticleProvider> mesarticles=new ArrayList();
		
		List<Article> ArticleSansProvider=articleRepositorty.findAll();
		
		for(Article article : ArticleSansProvider) {
			Provider provider = restTemplate.getForObject("http://provider-service/providers/"+article.getProviderId(), Provider.class);
			ArticleProvider article_provider = new ArticleProvider();
			article_provider.setArticle(article);
			article_provider.setProvider(provider);
			mesarticles.add(article_provider);

		}
		
		return mesarticles;
	}
	
	
	
}
