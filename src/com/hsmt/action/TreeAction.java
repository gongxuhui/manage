package com.hsmt.action;

import com.hsmt.service.TreeService;

import freemarker.log.Logger;

public class TreeAction {
	Logger logger = Logger.getLogger("LoginAction");
	private int id;// ������ڵ�
	private TreeService treeService;

	/* Ա���������ʵ�� */
	public void getTree() {
		treeService.getRoot(id);
		logger.info("action����ʵ��Ա�������  �ڵ�id-->" + id);
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
