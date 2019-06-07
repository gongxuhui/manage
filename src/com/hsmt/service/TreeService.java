package com.hsmt.service;

import net.sf.json.JSONArray;

public interface TreeService {
	/* 实现员工信息的左侧树 */
	public JSONArray getRoot(int id);

	/* 实现产品信息的左侧树 */
	public JSONArray getProductRoot(int id);

}
