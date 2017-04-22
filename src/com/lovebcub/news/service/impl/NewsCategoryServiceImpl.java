package com.lovebcub.news.service.impl;

import java.util.List;

import com.lovebcub.news.dao.NewsCategoryDao;
import com.lovebcub.news.dao.impl.NewsCategoryDaoImpl;
import com.lovebcub.news.entity.NewsCategory;
import com.lovebcub.news.service.NewsCategoryService;

public class NewsCategoryServiceImpl implements NewsCategoryService{
	private NewsCategoryDao newsCategoryDao;
	public NewsCategoryServiceImpl(){
		
		newsCategoryDao =new NewsCategoryDaoImpl();
		//constructor function
		
	}
	public List<NewsCategory> getNewsCategoryList() {
		return newsCategoryDao.getNewsCategoryList();
	}

}
