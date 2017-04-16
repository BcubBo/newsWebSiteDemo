package com.lovebcub.news.dao;
import java.util.List;

import com.lovebcub.news.entity.News;

public interface NewsDao {
	
	public List<News> getNewsList();
	public boolean add(News news);
	public boolean update(News news );
	public boolean delete(News news );
	
	public int  getNewsCount(News news);
	//根据新闻ID查找新闻明细
	
	public News getNewsById(int  id);
	
}
