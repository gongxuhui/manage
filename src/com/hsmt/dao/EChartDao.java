package com.hsmt.dao;

import java.util.List;

import com.hsmt.entity.Employee;
import com.hsmt.entity.Indent;
import com.hsmt.entity.Product;
import com.hsmt.entity.Profit;

public interface EChartDao {
	/* 获取部门员工数据 */
	public List<Employee> getGroupData();

	/* 获取员工薪水数据 */
	public List<Employee> getSalaryData();

	/* 获取员工薪水数据 */
	public List<Employee> getGroupLevelData(String group);

	/* 获取产品数据 */
	public List<Product> getProductData();

	/* 获取总销售数据 */
	public List<Indent> getIndentData();

	/* 获取地区销售数据 */
	public List<Product> getAreaData(String area);

	/* 获取地区销售数据 */
	public List<Profit> getProfitData13();

	/* 获取14年盈利数据 */
	public List<Profit> getProfitData14();

	/* 获取15年盈利数据 */
	public List<Profit> getProfitData15();
}
