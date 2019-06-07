package com.hsmt.action;

import org.apache.log4j.Logger;

import com.hsmt.service.BoxService;

public class BoxAction {
	Logger logger = Logger.getLogger("BoxAction");
	private int id;
	private String text;
	private BoxService boxService;

	/* 获取部门下拉菜单 */
	public void getGroupBox() {
		boxService.getGroupBox();
		logger.info("action层中执行了下拉菜单方法");
	}

	/* 获取部门下拉菜单 */
	public void getAreaBox() {
		boxService.getAeraBox();
		logger.info("action层中执行了下拉菜单方法");
	}

	/* 获取部门下拉菜单 */
	public void getLevelBox() {
		boxService.getLevelBox();
		logger.info("action层中执行了下拉菜单方法");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public BoxService getBoxService() {
		return boxService;
	}

	public void setBoxService(BoxService boxService) {
		this.boxService = boxService;
	}

}
