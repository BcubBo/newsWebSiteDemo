package com.lovebcub.news.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lovebcub.news.entity.News;
import com.lovebcub.news.service.NewsService;
import com.lovebcub.news.service.impl.NewsServiceImpl;


/**
 * Servlet implementation class addNewsServlet
 */


public class addNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		System.out.println(">>>>>>>>>>>>>>>初始化操作");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println(">>>>>>>>>>>>>>>>>>销毁操作");
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>>>>>>调度器启动");
		super.service(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>>doGet()请求被调用");
			NewsService newsService = new NewsServiceImpl();

			
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			String uploadPath = request.getSession().getServletContext().getRealPath("upload/");
			//getRealPath("upload/")获得项目部署的真实路径
			//request.getSession().getServletContext().getRealPath("upload/")获得项目部署在服务器上的真实路径下的upload文件夹并进行判断是否存在根目录下的文件夹下在添加一个upload文件夹

		//判断文件夹是否存在
			File saveDir = new File(uploadPath);
			News news = new News(); 
			news.setCreateDate(new Date());
			if(!saveDir.exists()){
				saveDir.mkdir();
				//创建文件夹
			}
			if(isMultipart){
				//处理文件上传
				try{
				FileItemFactory factory = new DiskFileItemFactory();
				 
				ServletFileUpload upload = new ServletFileUpload(factory);
				//解析请求

				List<FileItem> items  = upload.parseRequest(request);
				Iterator<FileItem> iteratorsObj = items.iterator();
				while(iteratorsObj.hasNext()){
					
					FileItem item = iteratorsObj.next();
			
					if(item.isFormField()){
			
						//若是普通的文本表单控件
						String fieldName = item.getFieldName();
						System.out.println("itemObj:"+item);
							if(fieldName.equals("categoryId")){
			
								
								news.setCategoryId(Integer.parseInt(item.getString()));
								
								
							}else if(fieldName.equals("title")){
			
			
								news.setTitle(item.getString("utf-8"));
								//u8防止乱码，获取文本域value的值
							}else if(fieldName.equals("author")){
			
			
								news.setAuthor(item.getString("utf-8"));
							}else if(fieldName.equals("summary")){
								news.setSummary(item.getString("utf-8"));
			
			
							}else if(fieldName.equals("newscontent")){
								news.setContent(item.getString("utf-8"));
			
			
							}
						}else{
							//若是文件域
							
			
							System.out.println("itemObj:"+item);
							String fileTotalPath = item.getName();//返回的是带有完全路径的路径名，这里获取的是原始上传位置的客户端磁盘文件路径
			//只是为了获得最终的文件名称
			
							if(fileTotalPath!=null && !fileTotalPath.equals("")){
			
								File fileFullPath = new File(fileTotalPath);
								File saveFile = new File(uploadPath,fileFullPath.getName());
								news.setPicPath(fileFullPath.getName());
								item.write(saveFile);
								//上传操作，将文件进行上传位置的重新改写到服务器下的位置，文件名不变，为原始文件名
								
								//上传文件到指定路径
								
							}
						
					
						//若是文件表单控件
						
						
					}
					
					
					
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}
				
				
			}
			boolean flag = newsService.add(news);
			if(flag){
				response.sendRedirect("newsDetailList.jsp");
				//request.getRequestDispatcher("newsDetailList.jsp").forward(request,response);
			
			
			
				
				
			}else{
			
			
			
			
			
			
			
			}
			
			
			
			
			
			
			
			
			
			//解析请求前，先判断是否为文件上传类型
				
			//编写js代码进行form表单验证
				
				
				
				
			//设置请求的字符编码utf-8
				/* request.setCharacterEncoding("utf-8");
				String categoryId = request.getParameter("categoryId");
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String summary = request.getParameter("summary");
				String content = request.getParameter("newscontent");
				//从请求中取出数据，提交数据库
				
				news.setAuthor(author);
				news.setCategoryId(Integer.parseInt(categoryId));
				news.setContent(content);
				news.setSummary(summary);
				news.setTitle(title);
				news.setCreateDate(new Date()); */
				
			
			
			
			






		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		//此为自动进行调用的方法，doGet和doPost进行了整合
	}

}
