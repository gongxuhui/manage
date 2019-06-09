package com.hsmt.dao;

import org.jfree.data.general.DefaultPieDataset;

public interface FreeChartDao {
	/*从数据库获取数据*/
	public DefaultPieDataset getFreeChartData();
}
