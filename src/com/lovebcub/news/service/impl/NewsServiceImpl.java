package com.lovebcub.news.service.impl;
import java.util.List;

import com.lovebcub.news.dao.BaseDao;
import com.lovebcub.news.dao.NewsCategoryDao;
import com.lovebcub.news.dao.NewsDao;
import com.lovebcub.news.dao.impl.NewsCategoryDaoImpl;
import com.lovebcub.news.dao.impl.NewsDaoImpl;
import com.lovebcub.news.entity.News;
import com.lovebcub.news.entity.NewsCategory;
import com.lovebcub.news.service.NewsService;
public class NewsServiceImpl  extends BaseDao implements NewsService {

	NewsDao newsDao = new NewsDaoImpl();
	NewsCategoryDao newsCategoryDao = new NewsCategoryDaoImpl();
	public NewsCategoryDao getNewsCategoryDao() {
		return newsCategoryDao;
	}
	public void setNewsCategoryDao(NewsCategoryDao newsCategoryDao) {
		this.newsCategoryDao = newsCategoryDao;
	}
	public void setNewsDao(NewsDao newsDao){
		
		
		
		this.newsDao = newsDao;
	}
	public NewsDao getNewsDao(){ 
		
		return newsDao;
		
	}
	//后续的news_category表的操作逻辑
	public List<News> getNewsList() {
		
		return newsDao.getNewsList();
	}
	

	
	public boolean add(News news) {
		
		return newsDao.add(news);
	}

	
	public boolean update(News news) {
		
		return false;
	}

	
	public boolean delete(News news) {
		
		return false;
	}

	
	public boolean deleteNewsCategoryService(NewsCategory newsCategory){
		//进行逻辑封装,删除新闻标题分类
		boolean flag = false;
		//根据categoryId查询新闻信息（count)
		News news = new News();
		news.setCategoryId(newsCategory.getId());
		int count = newsDao.getNewsCount(news);
		if(count>0){
			
			System.out.println("该类别下有新闻信息，请先删除新闻信息");
			//进行相应的删除操作
			//可添加相应的判断
			 
				
			}else{
				if(new NewsCategoryDaoImpl().deleteNewsCategory(newsCategory)){
					
					flag=true;
			}
			
		}
		
		//根据categoryId删除新闻信息(count);
		
		return flag;
		
	}
	
}
