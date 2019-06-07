package com.hsmt.action;

import com.hsmt.service.LoginService;

import freemarker.log.Logger;

public class LoginAction {
	Logger logger = Logger.getLogger("LoginAction");
	private LoginService loginService;
	private String userName;
	private String passWord;

	// 登录入口
	public String login() {
		String result = loginService.loginByNamePwd(userName, passWord);
		logger.info("action层中程序的登录入口");
		return result;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
