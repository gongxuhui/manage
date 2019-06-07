package com.hsmt.dao;

import java.util.List;

import com.hsmt.entity.Employee;
import com.hsmt.entity.Indent;
import com.hsmt.entity.Product;
import com.hsmt.entity.Profit;

public interface EChartDao {
	/* ��ȡ����Ա������ */
	public List<Employee> getGroupData();

	/* ��ȡԱ��нˮ���� */
	public List<Employee> getSalaryData();

	/* ��ȡԱ��нˮ���� */
	public List<Employee> getGroupLevelData(String group);

	/* ��ȡ��Ʒ���� */
	public List<Product> getProductData();

	/* ��ȡ���������� */
	public List<Indent> getIndentData();

	/* ��ȡ������������ */
	public List<Product> getAreaData(String area);

	/* ��ȡ13��ӯ������ */
	public List<Profit> getProfitData13();

	/* ��ȡ14��ӯ������ */
	public List<Profit> getProfitData14();

	/* ��ȡ15��ӯ������ */
	public List<Profit> getProfitData15();
}
