package com.lovebcub.news.service.impl;
import java.util.List;
import java.util.ArrayList;
import com.lovebcub.news.dao.NewsDao;
import com.lovebcub.news.dao.impl.NewsDaoImpl;
import com.lovebcub.news.entity.News;
import com.lovebcub.news.service.NewsService;
import com.lovebcub.news.dao.BaseDao;
import com.lovebcub.news.dao.NewsCategoryDao;
import com.lovebcub.news.entity.NewsCategory;
public class NewsServiceImpl  implements NewsService {

	NewsDao newsDao = new NewsDaoImpl();
	public void setNewsDao(NewsDao newsDao){
		
		
		
		this.newsDao = newsDao;
	}
	public NewsDao getNewsDao(){
		
		return newsDao;
		
	}
	public List<News> getNewsList() {
		
		return newsDao.getNewsList();
	}
	

	
	public boolean add(News news) {
		
		return false;
	}

	
	public boolean update(News news) {
		
		return false;
	}

	
	public boolean delete(News news) {
		
		return false;
	}

	
	public boolean deleteNewsCategory(NewsCategory newsCategory){
		//进行逻辑封装,删除新闻标题分类
		boolean flag = false;
		//根据categoryId查询新闻信息（count)
		News news = new News();
		news.setCategoryId(newsCategory.getId());
		int count = newsDao.getNewsCount(news);
		if(count>0){
			
			System.out.println("该类别下有新闻信息，请先删除新闻信息");
			return new NewsCategoryDao().deleteNewsCategory(newsCategory);
			
			
		}
		
		//根据categoryId删除新闻信息(count);
		
		return flag;
		
	}
	
}
