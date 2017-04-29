package com.lovebcub.news.listener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Application Lifecycle Listener implementation class servletContextDemo
 *
 */
public class servletContextDemo implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public servletContextDemo() {
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	
    	System.out.println("初始化ServletContext上下文");
    	
    	ServletContext servletContextObj = arg0.getServletContext();
    	
    	try {
			Context contextObj = new InitialContext();
			
			DataSource dataSourceObj = (DataSource)contextObj.lookup("java:comp/env/jdbc/news");
			
			servletContextObj.setAttribute("dataSourceObj",dataSourceObj);
					
		} catch (NamingException e) {
			e.printStackTrace();
		} 
    	
    }
	
}
