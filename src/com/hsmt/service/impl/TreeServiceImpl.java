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

	/* 通过父节点节点获取子节点 */
	public JSONArray getRoot(int id) {

		JSONArray jsonArray = null;
		try {
			jsonArray = json.getJsonByList(treeDao.getRootById(id));
		} catch (Exception e) {
			logger.error("serviceImpl层中获取子节点数据时出现异常-->", e);
		}
		logger.info("serviceImpl层中获取子节点数据jsonArray-->" + jsonArray);
		return jsonArray;
	}

	/* 通过默认节点获取子节点 */
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
