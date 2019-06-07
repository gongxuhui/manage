package com.hsmt.service.impl;

import com.hsmt.dao.LoginDao;
import com.hsmt.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private LoginDao loginDao;

	@Override
	public String loginByNamePwd(String userName, String passWord) {
		int a = loginDao.findByNamePwd(userName, passWord);
		String result = "error";
		if (a > 0) {
			result = "success";
		}
		return result;
	}

	public LoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
}
