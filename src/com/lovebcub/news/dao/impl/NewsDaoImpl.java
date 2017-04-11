package com.lovebcub.news.dao.impl;
import com.lovebcub.news.dao.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.lovebcub.news.entity.News;
import java.util.List;
import java.util.ArrayList;
public class NewsDaoImpl extends BaseDao implements NewsDao {

	
	public List<News> getNewsList() {
		List<News> newsList = new ArrayList<News>();
		//String sql = "select * from news_detail";
		//可能或增加为动态的进行数据库的相关操作
		String sql ="select detail.id,detail.categoryId,detail.title,detail.summary,detail.content,detail.author,detail.createDate,category.name as categoryName from news_detail as detail,news_category as category where detail.categoryId = category.id order by id DESC ";
		Object[] params = {};
		
		try {
			ResultSet resultSets = this.executeSql(sql,params);
			while(resultSets.next()){
				int  id = resultSets.getInt("id");
				int categoryId = resultSets.getInt("categoryId");
				String title = resultSets.getString("title");
				String summary = resultSets.getString("summary");//
				String content = resultSets.getString("content");
				String author = resultSets.getString("author");
				Timestamp createDate  = resultSets.getTimestamp("createDate");
				
				String picPath = 
resultSets.getString("picPath");
				Timestamp modifyDate = 
resultSets.getTimestamp("modifyDate");
				/*ystem.out.println("id:"+id+"\n"+
						"categoryId:"+categoryId+"\n"+
						"title:"+title+"\n"+
						"summary:"+summary+"\n"+
						"content:"+content+"\n"+
						"author:"+author+"\n"+
						"createDate:"+createDate+"\n"+
						"categoryName:"+categoryName+"\n"
				);
				*/
				News news = new News();
				news.setId(id);
				news.setCategoryId(categoryId);
				news.setTitle(title);
				news.setSummary(summary);
				news.setContent(content);
				news.setPicPath(picPath);
				news.setAuthor(author);
				news.setCreateDate(createDate);
				news.setModifyDate(modifyDate);
				newsList.add(news);
				
				
			}
			if(this.closeResource()){
				System.out.println("资源关闭成功");
			}else{
				System.out.println("资源关闭失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsList;
		//返回
		
	}

	
	public boolean  add(News news) {
		boolean flag = false;
	try{
		String sql = "insert into news_detail (id,categoryId,title,summary,content,author,createDate)values(?,?,?,?,?,?,?)";
		Object[] params = {news.getId(),news.getCategoryId(),news.getTitle(),news.getSummary(),news.getContent(),news.getAuthor(),news.getCreateDate()
				};
		int i = this.executeUpdate(sql, params);
		if(i>0){
			System.out.println("添加信息成功");
			flag = true;
			
		}else{
			System.out.println("添加信息失败");
			flag = false;
		}
		
	}finally{
		if(this.closeResource()){
			System.out.println("关闭资源成功");
		}else{
			System.out.println("关闭资源失败");
			
			}
		}
	return flag;
	}

//jdbc.connection.url = jdbc:mysql://localhost:3306/news?useSSL=false用useSSL=false来禁用ssl传输
	
	public boolean  update(News news) {
		boolean flag = false;
		try{
			String sql = "update news_detail set title=?,categoryId=? where id=?";
			Object[] params = {news.getTitle(),news.getCategoryId(),news.getId()};
			
			int i = this.executeUpdate(sql,params);
			
			
			
			if(i>0){
				System.out.println("更新信息成功");
				flag = true;
				
			}else{
				System.out.println("更新信息失败");
			}
			
		}finally{
			if(this.closeResource()){
				System.out.println("关闭资源成功");
			}else{
				System.out.println("关闭资源失败");
			}
		}
		
		return flag;
		
	}

	
	public boolean delete(News news) {
		boolean flag = false;
		try{
			String sql = "delete from news_detail where id=?";
			Object[] params = {news.getId()};
			int i = this.executeUpdate(sql, params);
			if(i>0){
				System.out.println("删除信息成功");
				flag = true;
			}else{
				System.out.println("删除信息失败");
			}
		}finally{
		
			
			if(this.closeResource()){
			System.out.println("关闭资源成功");
			}else{
			System.out.println("关闭资源失败");
				}
		}
		
		return flag;
	}
	
	public static void main(String[]args){
		
		NewsDaoImpl newsDaoImpl = new NewsDaoImpl();
		//newsDaoImpl.add(5, 1, "校园惊险恐龙", "一所校园出现食肉恐龙", "当地居民与其进行殊死搏斗", "BcubBo", (new Date()));
		//
		//newsDaoImpl.update(5, 1, "校园惊现恐龙");
		//newsDaoImpl.delete(5);
		newsDaoImpl.getNewsList();//列出
		
		
		
		
		
	}


////无用注释测试位置
}
	

