package com.lovebcub.news.entity;

import java.util.Date;

public class News {
	private int id ;//id
	private int categoryId;//分类id
	private String title;
	private String summary;
	
	private String content;
	private String picPath;
	private String author;
	private Date createDate;
	private Date modifyDate;
	private String categoryName;
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getId() {
		//获取id
		return id;
	}
	public void setId(int id) {
		//设置id
		this.id = id;
	}
	public int getCategoryId() {
		//设置分类id
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		//设置分类id
		this.categoryId = categoryId;
	}
	public String getTitle() {
		//获取标题
		return title;
	}
	public void setTitle(String title) {
		//设置标题
		this.title = title;
	}
	public String getContent() {
		//获取内容
		return content;
	}
	public void setContent(String content) {
		//设置内容
		this.content = content;
	}
	public String getPicPath() {
		//获取图片路径
		return picPath;
	}
	public void setPicPath(String picPath) {
		//设置图片路径
		this.picPath = picPath;
	}
	public String getAuthor() {
		//获取当前新闻作者
		return author;
	}
	public void setAuthor(String author) {
		//设置作者
		this.author = author;
	}
	public Date getCreateDate() {
		//获取创建日期
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		//设置创建日期
		this.createDate = createDate;
	}
	public Date getModifyDate() {
		//获取修改日期
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		//设置修改日期
		this.modifyDate = modifyDate;
	}
	public void setCategoryName(String categoryName){
		//设置categoryName别名
		this.categoryName = categoryName;
	}
	public String getCategoryName(){
		//获取categoryName
		return categoryName;
	}
}
