package com.hsmt.action;

import org.jfree.chart.JFreeChart;

import com.hsmt.service.FreeChartService;

import freemarker.log.Logger;

public class FreeChartAction {
	Logger logger = Logger.getLogger("FreeChartAction");
	private FreeChartService freeChartService;
	private JFreeChart chart;

	/* 获得产品信息的图表 */
	public String getProductCahrt() {
		chart = freeChartService.getProductFreeChart();
		logger.info("action层中获取产品信息的图表");
		return "chart";
	}

	public FreeChartService getFreeChartService() {
		return freeChartService;
	}

	public void setFreeChartService(FreeChartService freeChartService) {
		this.freeChartService = freeChartService;
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

}
