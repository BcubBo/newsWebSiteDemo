package com.lovebcub.news.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovebcub.news.entity.News;
import com.lovebcub.news.entity.NewsCategory;
import com.lovebcub.news.service.NewsCategoryService;
import com.lovebcub.news.service.NewsService;
import com.lovebcub.news.service.impl.NewsCategoryServiceImpl;
import com.lovebcub.news.service.impl.NewsServiceImpl;


/**
 * Servlet implementation class doModify
 */




public class doModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doModify() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NewsCategoryService newsCategoryService = new NewsCategoryServiceImpl();
		NewsService newsService = new NewsServiceImpl();
		//取得新闻分类列表
		List<NewsCategory> newsCategoryList = new ArrayList<NewsCategory>();
		newsCategoryList = newsCategoryService.getNewsCategoryList();
		
		
		request.setAttribute("newsCategoryList",newsCategoryList);
		
		//取得这个要修改的新闻信息明细
		String id = request.getParameter("id");
		//获取到了id
		News news = new News();
		news = newsService.getNewsById(Integer.parseInt(id));
		//将id所对应的信息导入到对象
		request.setAttribute("news",news);
		
		
		
		request.getRequestDispatcher("admin/adminNewsModify.jsp").forward(request, response);






	

		
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
