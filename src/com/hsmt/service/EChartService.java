package com.hsmt.service;

import net.sf.json.JSONObject;

public interface EChartService {
	/* ����Ա��������Ϣת��Ϊjson */
	public JSONObject getGroupJson();

	/* Ա��нˮ��Ϣת��Ϊjson */
	public JSONObject getSalaryJson();
	/*����dataIndex��ѯ���ڵȼ�*/
	public JSONObject getGroupLevelJson(int dataIndex);
	/* ��Ʒ��Ϣ����ת����json���� */
	public JSONObject getPieData();

	/* �ܲ�Ʒ������Ϣת����json���� */
	public JSONObject getIndentPieData();

	/* ������Ʒ������Ϣת����json���� */
	public JSONObject getAreaPieData(int dataIndex);

	/* ÿ��ӯ����Ϣת����json���� */
	public JSONObject geBarData();
}
