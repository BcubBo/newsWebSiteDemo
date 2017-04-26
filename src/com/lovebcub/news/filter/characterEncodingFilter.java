package com.lovebcub.news.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class characterEncodingFiter
 */
public class characterEncodingFilter implements Filter {
	public int requestCount,requestShutdownCount,responseCount,responseShutdownCount,
	chainCount,chainShutdownCount = 0;
	
	

    /**
     * Default constructor. 
     */
    public characterEncodingFilter() {
        
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// place your code here
		//过滤请求，设置字符编码格式为utf-8
		System.out.println(">>>>>>>>>>>>request过滤器启动统计:\t"+(requestCount+=1)+"----------------");
		request.setCharacterEncoding("utf-8");
		System.out.println(">>>>>>>>>>>>request过滤器启动结束:\t"+(requestShutdownCount+=1)+"----------------");
		
		//过滤响应设置字符编码为u8
		System.out.println(">>>>>>>>>>>>response过滤器启动:\t"+(responseCount+=1)+"----------------");
		response.setCharacterEncoding("utf-8");
		// pass the request along the filter chain
		//进入下一个过滤器（过滤器链条中的）或者进入web资源，
		System.out.println(">>>>>>>>>>>>request过滤器启动结束:\t"+(responseShutdownCount+=1)+"----------------");
		System.out.println(">>>>>>>>>>>>过滤器chain启动:\t"+(chainCount+=1)+"----------------");
		chain.doFilter(request, response);
		System.out.println(">>>>>>>>>>>>过滤器chain启动结束:\t"+(chainShutdownCount+=1)+"----------------");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
