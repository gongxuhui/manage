package com.hsmt.dao;

import org.jfree.data.general.DefaultPieDataset;

public interface FreeChartDao {
	/*从数据库中获取图表中的数据*/
	public DefaultPieDataset getFreeChartData();
}
