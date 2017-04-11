package com.lovebcub.news.dao;
import java.util.List;

import com.lovebcub.news.entity.News;
import com.lovebcub.news.entity.NewsCategory;
public interface NewsDao {
	
	public List<News> getNewsList();
	public boolean add(News news);
	public boolean update(News news );
	public boolean delete(News news );
	public boolean deleteNewsCategory(NewsCategory newsCategory);
	//删除新闻类别
}
