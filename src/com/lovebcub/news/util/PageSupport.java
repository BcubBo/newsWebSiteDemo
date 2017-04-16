package com.lovebcub.news.util;

public class PageSupport {
	private int totalPageCount = 1;
	//总页数
	private int totalCount  = 0;
	//总记录数
	private int currentPageNo = 1;
	//页码容量
	private int pageSize = 0;
	//页码大小
	public int getTotalPageCount() {
		//获取总页数
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		//设置总页数
		this.totalPageCount = totalPageCount;
	}
	public int getTotalCount() {
		//获取总记录数
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		//设置总记录数
		if(totalCount>0){
			this.totalCount = totalCount;
			//当获取总记录数的同时进行页面的页数的确定
			this.setTotalPageCountByCalc();
		}
		
	}
	public int getCurrentPageNo() {
		//获取页码容量
		return currentPageNo;
	}
	public void setCurrentPageNo(int currentPageNo) {
		//设置页码容量
		if(currentPageNo>0){
			this.currentPageNo = currentPageNo;
		}
		
	}
	public int getPageSize() {
		//获取页面大小
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		//设置页面大小
		if(pageSize>0){
			this.pageSize = pageSize;
		}
		
	}
	public void setTotalPageCountByCalc(){
		//通过计算进行页面大小，页面总数的确定
		if(this.totalCount%this.pageSize ==0){
			this.totalPageCount = this.totalCount/this.pageSize;
		}else if(this.totalCount%this.pageSize>0){
			this.totalPageCount=this.totalCount/this.pageSize+1;
		}else{
			this.totalPageCount = 0;
			//意外情况获取
		}
	}
	
	
	
}
