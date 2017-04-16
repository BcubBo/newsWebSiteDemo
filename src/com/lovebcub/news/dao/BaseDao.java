package com.lovebcub.news.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.lovebcub.news.util.ConfigManager;

public class BaseDao {
	protected Connection connection;
	protected PreparedStatement preparedSql;
	protected Statement statement;
	protected ResultSet resultSets;//
	
	public boolean getConnectionObj(){
		
		String driver = ConfigManager.getInstance().getString("jdbc.driver.class");
		String url = ConfigManager.getInstance().getString("jdbc.connection.url");
		String username = ConfigManager.getInstance().getString("jdbc.connection.username");
		String password = ConfigManager.getInstance().getString("jdbc.connection.password");
		//别忘了加载驱动
		try {
			Class.forName(driver);
			connection  = DriverManager.getConnection(url,username,password);
		} catch(SQLException e){
			e.printStackTrace();
			return false;
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
	//通过数据源来获取链接
	public Connection getConnectionObjUseDataSource(){
		//连接池模块
		//javax.naming包中的Context
		//
		try{
			//初始化Context对象
			//此对象也是一个流对象
			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/news");
			connection = dataSource.getConnection();
			//从数据源获取链接对象
			//添加java:comp/env/jdbc/news协议
			//////
			
		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		return connection;
		
		
		
		
		
		
	}
	public int executeUpdate(String sql ,Object[] params){
		
		int updateRows = 0;
		
		try{
			
			preparedSql = connection.prepareStatement(sql);
			for(int i =  0 ;i<params.length;i++){
				
				preparedSql.setObject(i+1, params[i]);
				
			}
			updateRows = preparedSql.executeUpdate();
			
			
		}catch(SQLException e){
			
			e.printStackTrace();
			updateRows = -1;
		}
		
		
		
		//更改操作
		
		
		return updateRows;
	}
	
	public ResultSet executeSql(String sql ,Object[] params){
		
			try{
				
				
				preparedSql = connection.prepareStatement(sql);
				for(int i = 0 ;i < params.length;i++){
					
					preparedSql.setObject(i+1, params[i]);
					
					
				}
				resultSets = preparedSql.executeQuery();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			
		
		return resultSets;
		
	}
	
	public boolean closeResource(){
		
		
		if(resultSets!=null){
			try{
				resultSets.close();
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
			
		}
		//
		if(statement!=null){
			
			try{
				statement.close();
				
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}
		//
		if(preparedSql!=null){
			try{
				
				preparedSql.close();
			}catch(SQLException e){
				
				e.printStackTrace();
				return false;
			}
		}
		//
		if(connection!=null){
			
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}
		
		
		
		return true;
		
	//关闭源	
	}
	
	
	
	
	
}
