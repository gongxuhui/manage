package com.hsmt.service.impl;

import com.hsmt.dao.TreeDao;
import com.hsmt.service.TreeService;
import com.hsmt.util.JsonUtil;

import freemarker.log.Logger;
import net.sf.json.JSONArray;

public class TreeServiceImpl implements TreeService {
	Logger logger = Logger.getLogger("TreeServiceImpl");
	private TreeDao treeDao;
	JsonUtil json = new JsonUtil();

	/* ͨ�����ڵ�ڵ��ȡ�ӽڵ� */
	public JSONArray getRoot(int id) {

		JSONArray jsonArray = null;
		try {
			jsonArray = json.getJsonByList(treeDao.getRootById(id));
		} catch (Exception e) {
			logger.error("serviceImpl���л�ȡ�ӽڵ�����ʱ�����쳣-->", e);
		}
		logger.info("serviceImpl���л�ȡ�ӽڵ�����jsonArray-->" + jsonArray);
		return jsonArray;
	}

	/* ͨ��Ĭ�Ͻڵ��ȡ�ӽڵ� */
	public JSONArray getProductRoot(int id) {

		return json.getJsonByList(treeDao.getProductRootById(id));
	}

	public TreeDao getTreeDao() {
		return treeDao;
	}

	public void setTreeDao(TreeDao treeDao) {
		this.treeDao = treeDao;
	}

}
