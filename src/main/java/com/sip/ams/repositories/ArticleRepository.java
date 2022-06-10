package com.sip.ams.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sip.ams.entities.Article;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	Article findArticleById(Long articleId);
	List<Article> findAll();
}
