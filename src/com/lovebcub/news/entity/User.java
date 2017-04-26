package com.lovebcub.news.entity;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import com.lovebcub.news.contants.userContants;

/**
 * Application Lifecycle Listener implementation class User
 *
 */
public class User implements HttpSessionBindingListener {
	//HttpSessionBindingListener
	private int  id;
	private String userName;
	private String email;
	
	
	
	
	
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
     * Default constructor. 
     */
    public User() {
        
    }

	/**
     * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
     */
    public void valueBound(HttpSessionBindingEvent arg0)  {
    	//自动调用的方法，并进行在线人数的统计
    	System.out.println("userContants.USER_ONLINE_COUNT++执行");
         userContants.USER_ONLINE_COUNT++;
    }

	/**
     * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
     */
    public void valueUnbound(HttpSessionBindingEvent arg0)  { 
    	//当session失效的时候，自动调用，执行在线人数-1
    	System.out.println("userContants.USER_ONLINE_COUNT--执行");
    	userContants.USER_ONLINE_COUNT--;
         
    }
	
}
