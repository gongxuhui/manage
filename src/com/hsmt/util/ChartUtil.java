package com.hsmt.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

public class ChartUtil {
	/* 生成饼状图 */
	public JFreeChart makePieChart(String title, DefaultPieDataset dataset) {
		// 解决乱码问题和设置显示文字的格式
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("黑体", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("宋体", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);
		// 创建拼状图
		JFreeChart pieChart = ChartFactory.createPieChart(title, dataset, true, true, true);
		// 取得饼图的Plot对象
		PiePlot plot = (PiePlot) pieChart.getPlot();
		// 用来显示标注的注解，{0}:{1}用来设置显示的格式
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}{1}({2})"));
		// 设置背景颜色
		plot.setBackgroundPaint(Color.lightGray);
		// 设置边框颜色
		plot.setBaseSectionOutlinePaint(Color.green);
		// 设置边框粗细
		plot.setBaseSectionOutlineStroke(new BasicStroke(0));

		// 设置标题
		TextTitle texttitle = pieChart.getTitle();
		texttitle.setFont(new Font("宋体", Font.BOLD, 30));
		// 设置图例
		LegendTitle legendtitle = pieChart.getLegend();
		legendtitle.setItemFont(new Font("宋体", Font.BOLD, 18));
		return pieChart;
	}
}
