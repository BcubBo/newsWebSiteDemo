package com.lovebcub.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lovebcub.news.dao.NewsDao;
import com.lovebcub.news.dao.impl.NewsDaoImpl;
import com.lovebcub.news.entity.News;

/**
 * Servlet implementation class deleteNews
 */

public class deleteNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteNews() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(">>>>>>>>>>>>删除方法中的doGet()别调用<<<<<<<<<<<<<");
		
		
		News news = new News();
		String id = request.getParameter("id");
		//获取了id
		news.setId(Integer.parseInt(id));
		NewsDao newsDao = new NewsDaoImpl();
		newsDao.delete(news);
		response.sendRedirect("admin/newsDetailList.jsp");
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
