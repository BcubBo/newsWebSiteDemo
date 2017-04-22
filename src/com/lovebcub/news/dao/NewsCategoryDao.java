package com.lovebcub.news.dao;

import java.util.List;

import com.lovebcub.news.entity.NewsCategory;

public interface  NewsCategoryDao {
	//根据id删除新闻类别
	public boolean deleteNewsCategory(NewsCategory newsCategory);
	
	//获取新闻分类列表
	
	public List<NewsCategory> getNewsCategoryList();
	
}
