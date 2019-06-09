package com.hsmt.service;

import net.sf.json.JSONArray;

public interface TreeService {
	/* 员工左侧树 */
	public JSONArray getRoot(int id);
	/* 产品左侧树 */
	public JSONArray getProductRoot(int id);

}
