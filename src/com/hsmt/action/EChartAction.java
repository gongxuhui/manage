package com.hsmt.action;

import org.apache.log4j.Logger;

import com.hsmt.service.EChartService;

public class EChartAction {
	Logger logger = Logger.getLogger("EChartAction");
	private int dataIndex;// 数据索引
	private EChartService eChartService;

	/* 获取饼状图 部门人数信息的json数据 */
	public void getGroupData() {
		eChartService.getGroupJson();
	}

	/* 根据dataIndex获取饼状图 部门中员工等级 */
	public void getGroupLevelData() {
		eChartService.getGroupLevelJson(dataIndex);
		System.out.println(dataIndex);
		logger.info("action层中获取饼状图的员工等级所用的dataIndex-->" + dataIndex);

	};

	/* 获取饼状图 员工薪水信息 */
	public void getSalaryData() {
		eChartService.getSalaryJson();
		logger.info("action层中获取饼状图的员工薪水信息数据");
	}

	/* 获取饼状图 产品信息的json数据 */
	public void getPieData() {
		eChartService.getPieData();
		logger.info("action层中获取饼状图的产品信息数据");
	}

	/* 获取饼状图 总销售信息的json数据 */
	public void getIndentPieData() {
		eChartService.getIndentPieData();
		logger.info("action层中获取饼状图总销售信息数据");
	}

	/* 获取饼状图 地区销售信息的json数据 */
	public void getAreaPieData() {
		eChartService.getAreaPieData(dataIndex);
		logger.info("action层中获取饼状图地区销售信息数据");
	}

	/* 获取条形图 盈利信息的json数据 */
	public void getBarData() {
		eChartService.geBarData();
		logger.info("获取条形图 盈利信息的json数据");
	}

	public EChartService geteChartService() {
		return eChartService;
	}

	public void seteChartService(EChartService eChartService) {
		this.eChartService = eChartService;
	}

	public int getDataIndex() {
		return dataIndex;
	}

	public void setDataIndex(int dataIndex) {
		this.dataIndex = dataIndex;
	}

}
