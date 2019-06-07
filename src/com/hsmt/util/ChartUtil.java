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
	/* ���ɱ�״ͼ */
	public JFreeChart makePieChart(String title, DefaultPieDataset dataset) {
		/* ������������������ʾ���ֵĸ�ʽ */
		StandardChartTheme mChartTheme = new StandardChartTheme("CN");
		mChartTheme.setLargeFont(new Font("����", Font.BOLD, 20));
		mChartTheme.setExtraLargeFont(new Font("����", Font.PLAIN, 15));
		mChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
		ChartFactory.setChartTheme(mChartTheme);
		/* ����ƴ״ͼ�ķ��� */
		JFreeChart pieChart = ChartFactory.createPieChart(title, dataset, true, true, true);
		/* ȡ�ñ�ͼ��Plot���� */
		PiePlot plot = (PiePlot) pieChart.getPlot();
		/* ������ʾ��ע��ע�⣬{0}:{1}����������ʾ�ĸ�ʽ */
		plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}{1}({2})"));
		/* ���ñ�����ɫ */
		plot.setBackgroundPaint(Color.lightGray);
		/* ���ñ߿���ɫ */
		plot.setBaseSectionOutlinePaint(Color.green);
		/* ���ñ߿��ϸ */
		plot.setBaseSectionOutlineStroke(new BasicStroke(0));

		/* ���ñ��� */
		TextTitle texttitle = pieChart.getTitle();
		texttitle.setFont(new Font("����", Font.BOLD, 30));
		/* ����ͼ�� */
		LegendTitle legendtitle = pieChart.getLegend();
		legendtitle.setItemFont(new Font("����", Font.BOLD, 18));
		return pieChart;
	}
}
