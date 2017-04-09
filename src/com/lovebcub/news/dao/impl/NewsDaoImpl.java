package com.lovebcub.news.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class NewsDaoImpl extends BaseDao implements NewsDao {

	
	public void getNewsList() {
		String sql = "select * from news_detail";
		Object[] params = {};
		
		try {
			ResultSet resultSets = this.executeSql(sql,params);
			while(resultSets.next()){
				int  id = resultSets.getInt("id");
				int categoryId = resultSets.getInt("categoryId");
				String title = resultSets.getString("title");
				String summary = resultSets.getString("summary");
				String content = resultSets.getString("content");
				String author = resultSets.getString("author");
				Timestamp createDate  = resultSets.getTimestamp("createDate");
				System.out.println("id:"+id+"\n"+
						"categoryId:"+categoryId+"\n"+
						"title:"+title+"\n"+
						"summary:"+summary+"\n"+
						"content:"+content+"\n"+
						"author:"+author+"\n"+
						"createDate:"+createDate+"\n"
				);
				
			}
			if(this.closeResource()){
				System.out.println("资源关闭成功");
			}else{
				System.out.println("资源关闭失败");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public void add(int id, int categoryId, String title, String summary, String content, String author,
			Date createDate) {
	try{
		String sql = "insert into news_detail (id,categoryId,title,summary,content,author,createDate)values(?,?,?,?,?,?,?)";
		Object[] params = {id,categoryId,title,summary,content,author,(new Timestamp(createDate.getTime()))
				};
		int i = this.executeUpdate(sql, params);
		if(i>0){
			System.out.println("添加信息成功");
			
		}else{
			System.out.println("添加信息失败");
		}
		
	}finally{
		if(this.closeResource()){
			System.out.println("关闭资源成功");
		}else{
			System.out.println("关闭资源失败");
		}
		}
	}
//jdbc.connection.url = jdbc:mysql://localhost:3306/news?useSSL=false用useSSL=false来禁用ssl传输
	
	public void update(int id, int categoryId, String title) {
		try{
			String sql = "update news_detail set title=?,categoryId=? where id=?";
			Object[] params = {title,categoryId,id};
			
			int i = this.executeUpdate(sql,params);
			
			
			
			if(i>0){
				System.out.println("更新信息成功");
				
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
		
		
		
	}

	
	public void delete(int id) {
		try{
			String sql = "delete from news_detail where id=?";
			Object[] params = {id};
			int i = this.executeUpdate(sql, params);
			if(i>0){
				System.out.println("删除信息成功");
				
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
	

