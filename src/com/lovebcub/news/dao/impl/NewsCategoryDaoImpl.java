package com.lovebcub.news.dao.impl;

import com.lovebcub.news.dao.BaseDao;
import com.lovebcub.news.entity.NewsCategory;
public class NewsCategoryDaoImpl extends BaseDao{
	public boolean deleteNewsCategory(NewsCategory newsCategory){
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
}
