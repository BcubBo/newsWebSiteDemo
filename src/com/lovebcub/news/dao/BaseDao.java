package com.lovebcub.news.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import com.lovebcub.news.util.ConfigManager;

public class BaseDao {
	protected Connection connection;
	protected PreparedStatement preparedSql;
	protected Statement statement;
	protected ResultSet resultSets;
	
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
	
	public int executeUpdate(String sql ,Object[] params){
		
		int updateRows = 0;
		if(getConnectionObj()){
		try{
			
			preparedSql = connection.prepareStatement(sql);
			for(int i =  0 ;i<params.length;i++){
				
				preparedSql.setObject(i+1, params[i]);
				
			}
			updateRows = preparedSql.executeUpdate();
			
			
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		
		
		
		//更改操作
		
		}
		return updateRows;
	}
	
	public ResultSet executeSql(String sql ,Object[] params){
		if(getConnectionObj()){
			try{
				
				
				preparedSql = connection.prepareStatement(sql);
				for(int i = 0 ;i < params.length;i++){
					
					preparedSql.setObject(i+1, params[i]);
					
					
				}
				resultSets = preparedSql.executeQuery();
			}catch(SQLException e){
				e.printStackTrace();
			}
			
			
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
