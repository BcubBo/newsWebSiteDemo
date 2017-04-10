package com.lovebcub.news.dao;
import java.util.Date;
public interface NewsDao {
	
	public void getNewsList();
	public void add(int id ,int categoryId,String title,String summary,String content,String author,Date createTime);
	public void update(int id ,int categoryId,String title);
	public void delete(int id);
}
