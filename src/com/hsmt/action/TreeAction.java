package com.hsmt.action;

import com.hsmt.service.TreeService;

import freemarker.log.Logger;

public class TreeAction {
	Logger logger = Logger.getLogger("LoginAction");
	private int id;// 左侧树节点
	private TreeService treeService;

	/* 员工左侧树的实现 */
	public void getTree() {
		treeService.getRoot(id);
		logger.info("action层中实现员工左侧树  节点id-->" + id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TreeService getTreeService() {
		return treeService;
	}

	public void setTreeService(TreeService treeService) {
		this.treeService = treeService;
	}
}
