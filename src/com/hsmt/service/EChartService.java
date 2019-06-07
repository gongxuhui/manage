package com.hsmt.service;

import net.sf.json.JSONObject;

public interface EChartService {
	/* 部门员工人数信息转化为json */
	public JSONObject getGroupJson();

	/* 员工薪水信息转化为json */
	public JSONObject getSalaryJson();
	/*根据dataIndex查询组内等级*/
	public JSONObject getGroupLevelJson(int dataIndex);
	/* 产品信息数据转化成json数据 */
	public JSONObject getPieData();

	/* 总产品销售信息转化成json数据 */
	public JSONObject getIndentPieData();

	/* 地区产品销售信息转化成json数据 */
	public JSONObject getAreaPieData(int dataIndex);

	/* 每月盈利信息转化成json数据 */
	public JSONObject geBarData();
}
