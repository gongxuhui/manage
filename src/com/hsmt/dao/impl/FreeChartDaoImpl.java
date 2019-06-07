package com.hsmt.dao.impl;

import org.jfree.data.general.DefaultPieDataset;

import com.hsmt.dao.FreeChartDao;
import com.hsmt.util.DbUtil;

public class FreeChartDaoImpl implements FreeChartDao {
	DbUtil db = new DbUtil();

	@Override
	public DefaultPieDataset getFreeChartData() {
		String sql = "SELECT p.`product_name`,p.`product_stock` FROM product p ";
		db.dataConversion(sql);
		return db.dataConversion(sql);
	}
}
