package com.lovebcub.news.service;
import java.util.List;

import com.lovebcub.news.entity.News;
import com.lovebcub.news.entity.NewsCategory;
public interface NewsService {
		public List<News> getNewsList();
		public boolean add(News news);
		//添加数据库
		public boolean update(News news );
		//更新数据库
		public boolean delete(News news );
		//删除新闻信息
		public News getNewsById(int id);
		//获取新闻的总条数
		public int getNewsCount();
		//获取新闻分页列表
		public List<News> getPageNewsList(int pageNo,int pageSize);

}
