package com.hsmt.dao.impl;

import com.hsmt.dao.LoginDao;
import com.hsmt.util.DbUtil;

public class LoginDaoImpl implements LoginDao {

	public int findByNamePwd(String userName, String passWord) {
		DbUtil jb = new DbUtil();
		System.out.println(userName);
		String sql = "select * from user where name= + '" + userName + "' and '" + passWord + "'";
		return jb.count(sql);
	}

}
