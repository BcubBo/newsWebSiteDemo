package com.lovebcub.news.mainStart;

import com.lovebcub.news.dao.NewsCategoryDao;
import com.lovebcub.news.dao.NewsDao;
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
		NewsCategoryDao newsCategoryDao = new NewsCategoryDaoImpl();
		//新闻分类的Dao创建
		
		newsService.setNewsDao(newsDao);
		//传值
		newsService.setNewsCategoryDao(newsCategoryDao);
		//传值到NewsServiceImpl文件
		
		NewsCategory newsCategory = new NewsCategory();
		newsCategory.setId(3);
		
		if(newsService.deleteNewsCategoryService(newsCategory)){
			System.out.println("删除成功");
		}
		
		
	}
}
