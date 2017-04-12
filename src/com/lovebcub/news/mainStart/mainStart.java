package com.lovebcub.news.mainStart;

import com.lovebcub.news.dao.NewsCategoryDao;
import com.lovebcub.news.dao.NewsDao;
import com.lovebcub.news.dao.impl.NewsCategoryDaoImpl;
import com.lovebcub.news.dao.impl.NewsDaoImpl;
import com.lovebcub.news.service.impl.NewsServiceImpl;

public class mainStart {
	public static void main(String[]args){
		NewsServiceImpl newsService = new NewsServiceImpl();
		NewsDao newsDao = new NewsDaoImpl();
		NewsCategoryDao newsCategoryDao = new NewsCategoryDaoImpl();
		
		newsService.setNewsDao(newsDao);
		//传值
		newsService.setNewsCategoryDao(newsCategoryDao);
		//传值到NewsServiceImpl文件
		
		
	}
}
