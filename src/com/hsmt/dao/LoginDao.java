package com.hsmt.dao;

public interface LoginDao {
	
	public int findByNamePwd(String userName,String passWord); 
	
}
