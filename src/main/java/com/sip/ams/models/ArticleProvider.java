package com.sip.ams.models;

import com.sip.ams.entities.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class ArticleProvider {
	private Article article;
	private Provider provider;
}
