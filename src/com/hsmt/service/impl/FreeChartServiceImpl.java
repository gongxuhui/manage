package com.hsmt.service.impl;

import org.jfree.chart.JFreeChart;
import com.hsmt.dao.FreeChartDao;
import com.hsmt.service.FreeChartService;
import com.hsmt.util.ChartUtil;

public class FreeChartServiceImpl implements FreeChartService {
	ChartUtil cu = new ChartUtil();
	private FreeChartDao freeChartDao;

	@Override
	public JFreeChart getProductFreeChart() {
		freeChartDao.getFreeChartData();
		return cu.makePieChart("²úÆ·¿â´æ", freeChartDao.getFreeChartData());
	}

	public FreeChartDao getFreeChartDao() {
		return freeChartDao;
	}

	public void setFreeChartDao(FreeChartDao freeChartDao) {
		this.freeChartDao = freeChartDao;
	}

}
