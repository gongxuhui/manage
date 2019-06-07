package com.hsmt.test;

import org.junit.Test;

import com.hsmt.dao.EChartDao;

public class TestEChart {
	@Test
	public void mmm() {
		EChartDao e = (EChartDao) new TestEChart();
		e.getIndentData();
		System.out.println(e.getIndentData().size());

	}
}
