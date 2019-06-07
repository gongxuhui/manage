package com.hsmt.service;

import net.sf.json.JSONArray;

public interface BoxService {
	/* 部门下拉框 */
	public JSONArray getGroupBox();

	/* 地区下拉框 */
	public JSONArray getAeraBox();

	/* 等级下拉框 */
	public JSONArray getLevelBox();
}
