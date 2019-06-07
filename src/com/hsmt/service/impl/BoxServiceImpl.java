package com.hsmt.service.impl;

import com.hsmt.dao.BoxDao;
import com.hsmt.service.BoxService;
import com.hsmt.util.JsonUtil;

import net.sf.json.JSONArray;

public class BoxServiceImpl implements BoxService {
	JsonUtil ju = new JsonUtil();
	private BoxDao boxDao;

	@Override
	public JSONArray getGroupBox() {
		return ju.getJsonByList(boxDao.findGroupBox());
	}

	@Override
	public JSONArray getAeraBox() {
		return ju.getJsonByList(boxDao.findAreaBox());
	}

	@Override
	public JSONArray getLevelBox() {
		return ju.getJsonByList(boxDao.findLevelBox());
	}

	public BoxDao getBoxDao() {
		return boxDao;
	}

	public void setBoxDao(BoxDao boxDao) {
		this.boxDao = boxDao;
	}

}
