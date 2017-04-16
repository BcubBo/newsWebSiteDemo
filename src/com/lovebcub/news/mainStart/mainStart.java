package com.lovebcub.news.mainStart;

import java.util.ArrayList;
import java.util.List;

import com.lovebcub.news.dao.NewsCategoryDao;
import com.lovebcub.news.dao.NewsDao;
import com.lovebcub.news.entity.News;
import com.lovebcub.news.dao.impl.NewsCategoryDaoImpl;
import com.lovebcub.news.dao.impl.NewsDaoImpl;
import com.lovebcub.news.entity.NewsCategory;
import com.lovebcub.news.service.impl.NewsServiceImpl;

public class mainStart {
	public static void main(String[]args){
	NewsServiceImpl newsService = new NewsServiceImpl();
		//进行服务的导入
		NewsDao newsDao = new NewsDaoImpl();
		//Dao文件的创建
		/*NewsCategoryDao newsCategoryDao = new NewsCategoryDaoImpl();
		//新闻分类的Dao创建
		
		newsService.setNewsDao(newsDao);
		//传值
		newsService.setNewsCategoryDao(newsCategoryDao);
		//传值到NewsServiceImpl文件
		
		NewsCategory newsCategory = new NewsCategory();
		newsCategory.setId(3);
		
		if(newsService.deleteNewsCategoryService(newsCategory)){
			System.out.println("删除成功");
		}*/
		//News news = newsService.getNewsById(13);
		//System.out.println("news======>"+news.getTitle());
		List<News> newsList = new ArrayList<News>();
		newsList = newsService.getPageNewsList(2, 3);
		for(News news:newsList){
			System.out.println("news page id ====>"+news.getId());
			System.out.println("news page author====>"+news.getAuthor());
			System.out.println("news page title====>"+news.getTitle());
			System.out.println("news page createDate====>"+news.getCreateDate());
		}
		
		
		
	}
}
