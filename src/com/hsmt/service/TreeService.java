package com.hsmt.service;

import net.sf.json.JSONArray;

public interface TreeService {
	/* ʵ��Ա����Ϣ������� */
	public JSONArray getRoot(int id);

	/* ʵ�ֲ�Ʒ��Ϣ������� */
	public JSONArray getProductRoot(int id);

}
