package com.lovebcub.news.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class httpSessionListenerDemo
 *
 */
public class httpSessionListenerDemo implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public httpSessionListenerDemo() {
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("HttpSessionListenter>>>>>>>sessionCreated启动");
    	
    	ServletContext servletContext = arg0.getSession().getServletContext();
    	
    	Integer count = (Integer)servletContext.getAttribute("count");
    	if(count == null){
    		
    		count = 1;
    		System.out.println(">>>>>>>>>>sessionCreated执行了初始化count操作");
    		
    	}
    	else{
    		
    		count = count.intValue()+1;
    		System.out.println(">>>>>>>>>>sessionCreated执行了+1操作");
    		
    		
    	}
    	servletContext.setAttribute("count", count);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	
    	System.out.println("HttpSessionListener>>>>>>>>sessionDestroyed启动");
    	ServletContext servletContext = arg0.getSession().getServletContext();
    	
    	Integer count = (Integer)servletContext.getAttribute("count");
    	
    	if(count.intValue() == 0 ){
    		
    		count = 0;
    		System.out.println(">>>>>>>>>>sessionDestroyed执行了归零操作");
    		
    	}else{
    		count = count.intValue()-1;
    		System.out.println(">>>>>>>>>>sessionDestroyed执行了-1操作");
    		
    		
    	}
    	
    	
    }
	
}
