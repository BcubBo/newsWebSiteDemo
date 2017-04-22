package com.lovebcub.news.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.lovebcub.news.dao.BaseDao;
import com.lovebcub.news.dao.NewsDao;
import com.lovebcub.news.entity.News;
public class NewsDaoImpl extends BaseDao implements NewsDao {

	
	public List<News> getNewsList() {
		List<News> newsList = new ArrayList<News>();
		//String sql = "select * from news_detail";
		//可能或增加为动态的进行数据库的相关操作
		String sql = "select detail.id,detail.categoryId,detail.title,detail.summary,detail.content,detail.author,detail.createDate,detail.picPath ,detail.modifyDate from news_detail as detail order by id DESC";
		//单表查询
		/*String sql ="select detail.id,detail.categoryId,detail.title,detail.summary,detail.content,detail.author,detail.createDate,category.name as categoryName,detail.picPath ,detail.modifyDate from news_detail as detail,news_category as category where detail.categoryId = category.id order by id DESC ";*/
		//连表查询
		Object[] params = {};
		if(this.getConnectionObj()){
		try {
			ResultSet resultSets = this.executeSql(sql,params);
			//返回的结果集里面包含从数据库添加进去的新对象
			while(resultSets.next()){
				int  id = resultSets.getInt("id");
				int categoryId = resultSets.getInt("categoryId");
				String title = resultSets.getString("title");
				String summary = resultSets.getString("summary");//
				String content = resultSets.getString("content");
				String author = resultSets.getString("author");
				Timestamp createDate  = resultSets.getTimestamp("createDate");
				
				String picPath = resultSets.getString("picPath");
				Timestamp modifyDate = resultSets.getTimestamp("modifyDate");
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
				//通过while将信息存储到每次新建的对象中
				//可以进行二次封装
				
			}
			if(this.closeResource()){
				System.out.println(">>>>>>>资源关闭成功");
			}else{
				System.out.println(">>>>>>>资源关闭失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		return newsList;
		//返回
		
	}

	
	public boolean  add(News news) {
		boolean flag = false;
		if(this.getConnectionObj()){
			try{
				String sql = "insert into news_detail (categoryId,title,summary,content,author,createDate,picPath)values(?,?,?,?,?,?,?)";
				Object[] params = {news.getCategoryId(),news.getTitle(),news.getSummary(),news.getContent(),news.getAuthor(),news.getCreateDate(),
						news.getPicPath()};
				int i = this.executeUpdate(sql, params);
			if(i>0){
				System.out.println(">>>>>>>添加信息成功");
				flag = true;
				
			}else{
				System.out.println(">>>>>>>添加信息失败");
				flag = false;
			}
			
			}finally{
				if(this.closeResource()){
					System.out.println(">>>>>>>关闭资源成功");
			}else{
				System.out.println(">>>>>>>关闭资源失败");
				
				}
			}
		}
	return flag;
	}
//测试位
//jdbc.connection.url = jdbc:mysql://localhost:3306/news?useSSL=false用useSSL=false来禁用ssl传输
	
	public boolean  update(News news) {
		boolean flag = false;
		if(this.getConnectionObj()){
		try{
			String sql = "update news_detail set categoryId=? where id=?";
			//String sql = "update news_detail set title=? where id=?";
			//sql语句原句
			//Object[] params = {news.getTitle(),news.getId()};
			Object[] params = {news.getCategoryId(),news.getId()};
			//进行了sql语句的更改
			
			int i = this.executeUpdate(sql,params);
			
			
			
			if(i>0){
				System.out.println("更新信息成功");
				flag = true;
				
			}else{
				System.out.println(">>>>>>>更新信息失败");
			}
			
		}finally{
			if(this.closeResource()){
				System.out.println(">>>>>>>关闭资源成功");
			}else{
				System.out.println(">>>>>>>关闭资源失败");
			}
		}
		}
		return flag;
		
	}

	
	public boolean delete(News news) {
		boolean flag = false;
		if(this.getConnectionObj()){
		try{
			String sql = "delete from news_detail where id=?";
			Object[] params = {news.getId()};
			//只取id
			int i = this.executeUpdate(sql, params);
			if(i>0){
				System.out.println(">>>>>>>删除子表信息成功");
				flag = true;
			}else{
				System.out.println(">>>>>>>删除子表信息失败");
			}
		}finally{
		
			
			if(this.closeResource()){
			System.out.println(">>>>>>>关闭资源成功");
			}else{
			System.out.println(">>>>>>>关闭资源失败");
				}
		}
		}
		
		return flag;
	}
	
	/*public boolean deleteNewsCategory(NewsCategory newsCategory){
		//进行逻辑封装,删除新闻标题分类
		boolean flag = false;
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
		
		return flag;
		
	}
	
	
	*/
	
	
	public int getNewsCount(News news) {
		int count = 0;
		String sql = "select count(1) as count from news_detail where categoryId=?";
		Object[] params = {news.getCategoryId()};
		//获取categoryId当中的新闻明细的条数
		if(this.getConnectionObj()){
			try{
				ResultSet resultSets = this.executeSql(sql, params);
				if(resultSets.next()){
					
					count = resultSets.getInt("count");
					
				}
				
			}catch(SQLException e){
				e.printStackTrace();
			
			
			
			}finally{
				this.closeResource();
			}
			
		}
		
		
		return count;
	}


	public News getNewsById(int id) {
		
		News news = new News();
		String sql = "select  n.*,cat.`name` as CategoryName from news_detail as n,news_category as cat where n.id = ? and n.categoryId = cat.id ";
		Object [] params = {id};
		if(this.getConnectionObj()){
			//return resultset 
			ResultSet resultSets = this.executeSql(sql, params);
			try{
				
				if(resultSets.next()){
					
					news.setId(resultSets.getInt("id"));
					news.setTitle(resultSets.getString("title"));
					news.setSummary(resultSets.getString("summary"));
					news.setAuthor(resultSets.getString("author"));
					news.setCategoryId(Integer.parseInt(resultSets.getString("categoryId")));	
					news.setPicPath(resultSets.getString("picPath"));
					news.setContent(resultSets.getString("content"));
					news.setCreateDate(resultSets.getTimestamp("createDate"));
					news.setCategoryName(resultSets.getString("categoryName"));
					
				}
				
				
				
				
				
			}catch(SQLException e){e.printStackTrace();
			}
			finally{
				this.closeResource();
			}
			
		}
		return news;
	}


	public int getNewsCount() {
		int count = 0;
		//获取数据的条数
		String sql = "select count(1) as count  from news_detail";
		Object[] params = {};
		if(this.getConnectionObj()){
			
			ResultSet resultSets = this.executeSql(sql, params);
			try {
				if(resultSets.next()){
					
					count = resultSets.getInt("count");
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeResource();
			}
		}
		
		return count;
	}


	public List<News> getPageNewsList(int pageNo, int pageSize) {
		List<News> newsList = new ArrayList<News>();
		String sql = "select id,title,author,createDate from news_detail order by createDate desc limit ?,?";
		pageNo = (pageNo-1)*pageSize;
		Object [] params = {pageNo,pageSize};
		if(this.getConnectionObj()){
			
			ResultSet resultSets = this.executeSql(sql, params);
			try {
				while(resultSets.next()){
					News news = new News();
					news.setId(resultSets.getInt("id"));
					news.setTitle(resultSets.getString("title"));
					news.setAuthor(resultSets.getString("author"));
					news.setCreateDate(resultSets.getTimestamp("createDate"));
					newsList.add(news);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				this.closeResource();
			}
			
		}
		//起始未知的确定
		return newsList;
	}
	
	
	
	
	
	
	
	
	

}
	

