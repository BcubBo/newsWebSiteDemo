package com.lovebcub.news.dao.impl;
import com.lovebcub.news.dao.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import com.lovebcub.news.entity.News;
import com.lovebcub.news.entity.NewsCategory;
import java.util.List;
import java.util.ArrayList;
public class NewsDaoImpl extends BaseDao implements NewsDao {

	
	public List<News> getNewsList() {
		List<News> newsList = new ArrayList<News>();
		//String sql = "select * from news_detail";
		//可能或增加为动态的进行数据库的相关操作
		String sql ="select detail.id,detail.categoryId,detail.title,detail.summary,detail.content,detail.author,detail.createDate,category.name as categoryName,detail.picPath ,detail.modifyDate from news_detail as detail,news_category as category where detail.categoryId = category.id order by id DESC ";
		Object[] params = {};
		
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
		String sql = "insert into news_detail (categoryId,title,summary,content,author,createDate)values(?,?,?,?,?,?)";
		Object[] params = {news.getCategoryId(),news.getTitle(),news.getSummary(),news.getContent(),news.getAuthor(),news.getCreateDate()
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
			String sql = "update news_detail set title=? where id=?";
			Object[] params = {news.getTitle(),news.getId()};
			
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
			//只取id
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
	
	public boolean deleteNewsCategory(NewsCategory newsCategory){
		//进行逻辑封装
		boolean flag = false;
		try{
		String sql = "delete from news_category where id=?";
		Object [] params = {newsCategory.getId()};
		int i =  this.executeUpdate(sql,params);
		if(i>0){
			System.out.println("删除新闻分类信息成功");
			flag = true;
		}else{
			System.out.println("删除新闻分类信息失败");
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

		News news = new News();
	
		news.setAuthor("BcubBo");
		news.setCategoryId(3);
		news.setTitle("惊险震惊一幕！");
		news.setSummary("惊险的过山车之旅！");
		news.setContent("一男子独自坐过山车被卡住半空中，午夜消防官兵前来营救");
		news.setCreateDate(new Date());
		newsDaoImpl.add(news);
		//进行信息的添加操作，将来也可以进行封装
		//news.setId(8);
		//newsDaoImpl.delete(news);
		//news.setId(5);
		//news.setTitle("相当的震惊！！！");
		//newsDaoImpl.update(news);
		List<News> newsList = new ArrayList<News>();
		//始终需要进行select将信息取出
		newsList = newsDaoImpl.getNewsList();//列出
		for(News _news:newsList){
			
			System.out.println("id:"+_news.getId()+"\n"+"categoryId:"+_news.getCategoryId()+"\n"+"title:"+_news.getTitle()+"\n"+"summary:"+_news.getSummary()+"\n"+"content:"+_news.getContent()+"\n"+"createDate:"+_news.getCreateDate()+"\n");
			
		}
		
		
		
		
		
	}





////无用注释测试位置
}
	

