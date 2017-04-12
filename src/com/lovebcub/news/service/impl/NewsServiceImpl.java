package com.lovebcub.news.service.impl;
import java.util.List;

import com.lovebcub.news.dao.NewsCategoryDao;
import com.lovebcub.news.dao.NewsDao;
import com.lovebcub.news.dao.impl.NewsDaoImpl;
import com.lovebcub.news.entity.News;
import com.lovebcub.news.entity.NewsCategory;
import com.lovebcub.news.service.NewsService;
import com.lovebcub.news.dao.BaseDao;
public class NewsServiceImpl  extends BaseDao implements NewsService,NewsCategoryDao {

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
			//进行相应的删除操作
			//可添加相应的判断

			if(this.getConnectionObj()){
				try{
					String delNewsDetailSql = "delete from news_detail where categoryId=?";
					String delNewsCategorySql = "delete from news_category where id=?";	
					//先删除子表，后删除主表
					Object [] params = {newsCategory.getId()};
					//关系约束条件
					int i = this.executeUpdate(delNewsDetailSql,params);
					
					if(i!=-1){
							System.out.println("删除新闻详细分类子表信息成功");		
							int j = 	this.executeUpdate(delNewsCategorySql,params);
						if(j>0){
							
							System.out.println("删除新闻详细分类主表信息成功");
							
						}
						
						flag = true;
					}else{
						System.out.println("删除新闻详细分类子主表信息失败");
					}
					
					
					}finally{
						if(this.closeResource()){
							System.out.println("关闭资源成功");
							
							
						}else{
							System.out.println("关闭资源失败");
						}
						
					}
				}
			
			
		}
		
		//根据categoryId删除新闻信息(count);
		
		return flag;
		
	}
	
}
