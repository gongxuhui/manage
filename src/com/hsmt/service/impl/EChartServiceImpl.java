package com.hsmt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.hsmt.dao.EChartDao;
import com.hsmt.entity.EChartPie;
import com.hsmt.entity.Employee;
import com.hsmt.entity.Indent;
import com.hsmt.entity.Product;
import com.hsmt.entity.Profit;
import com.hsmt.service.EChartService;
import com.hsmt.util.Area;
import com.hsmt.util.Group;
import com.hsmt.util.JsonUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EChartServiceImpl implements EChartService {
	JsonUtil ju = new JsonUtil();
	private EChartDao eChartDao;

	@Override
	public JSONObject getGroupJson() {
		List<Employee> dataList = null;
		dataList = eChartDao.getGroupData();
		/* 把部门名称信息封装到数组中 */
		String legend[] = new String[dataList.size()];
		for (int i = 0; i <= dataList.size() - 1; i++) {
			legend[i] = dataList.get(i).getEmpGroup();
		}

		/* 把部门人数情况信息信息封装到集合中转成json */
		List<EChartPie> groupData = new ArrayList<EChartPie>();
		for (int j = 0; j <= dataList.size() - 1; j++) {
			EChartPie pie = new EChartPie();
			pie.setName(dataList.get(j).getEmpGroup());
			pie.setValue(dataList.get(j).getAmount());
			groupData.add(pie);
			System.out.println(groupData.size());
		}
		JSONArray series = JSONArray.fromObject(groupData);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("legend", legend);
		map.put("series", series);
		return ju.getJsonByMap(map);

	}

	@Override
	public JSONObject getSalaryJson() {
		List<Employee> dataList = null;
		dataList = eChartDao.getSalaryData();
		System.out.println("adfafas" + dataList.size());
		/* 把员工等级信息封装到数组中 */
		String legend[] = new String[dataList.size()];
		for (int i = 0; i <= dataList.size() - 1; i++) {
			legend[i] = dataList.get(i).getEmpLevel();
		}

		/* 把员工信息信息封装到集合中转成json */
		List<EChartPie> salaryData = new ArrayList<EChartPie>();
		for (int j = 0; j <= dataList.size() - 1; j++) {
			EChartPie pie = new EChartPie();
			pie.setName(dataList.get(j).getEmpLevel());
			pie.setValue(dataList.get(j).getAverageSalary());
			salaryData.add(pie);
		}
		JSONArray series = JSONArray.fromObject(salaryData);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("legend", legend);
		map.put("series", series);
		ju.getJsonByMap(map);
		return ju.getJsonByMap(map);
	}

	@Override
	public JSONObject getGroupLevelJson(int dataIndex) {
		String group = Group.getInstance(dataIndex);
		List<Employee> dataList = eChartDao.getGroupLevelData(group);
		/* 把等级名称封装到数组中 */
		String legend[] = new String[dataList.size()];
		for (int i = 0; i <= dataList.size() - 1; i++) {
			legend[i] = dataList.get(i).getEmpLevel();
		}
		System.out.println(legend);
		/* 把等级信息封装到集合中转成json */
		List<EChartPie> amountData = new ArrayList<EChartPie>();
		for (int j = 0; j <= dataList.size() - 1; j++) {
			EChartPie pie = new EChartPie();
			pie.setValue(dataList.get(j).getAmount());
			pie.setName(dataList.get(j).getEmpLevel());
			amountData.add(pie);
		}
		JSONArray series = JSONArray.fromObject(amountData);
		System.out.println("serives" + series);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("legend", legend);
		map.put("series", series);
		return ju.getJsonByMap(map);
	}

	@Override
	public JSONObject getPieData() {
		List<Product> dataList = null;
		try {
			dataList = eChartDao.getProductData();
		} catch (Exception e) {
			System.out.println("查询数据异常" + e);
		}
		/* 把产品名字封装到数组中 */
		String legend[] = new String[dataList.size()];
		for (int i = 0; i <= dataList.size() - 1; i++) {
			legend[i] = dataList.get(i).getProduct_name();
		}
		/* 把库存量信息封装到集合中转成json */
		List<EChartPie> stockData = new ArrayList<EChartPie>();
		for (int j = 0; j <= dataList.size() - 1; j++) {
			EChartPie pie = new EChartPie();
			pie.setValue(dataList.get(j).getProduct_stock());
			pie.setName(dataList.get(j).getProduct_name());
			stockData.add(pie);
		}
		JSONArray series = JSONArray.fromObject(stockData);

		/* 把成产产品总数信息封装到集合中转成json */
		List<EChartPie> sumData = new ArrayList<EChartPie>();
		for (int j = 0; j <= dataList.size() - 1; j++) {
			EChartPie pie = new EChartPie();
			pie.setValue(dataList.get(j).getProduct_sum());
			pie.setName(dataList.get(j).getProduct_name());
			sumData.add(pie);
		}
		JSONArray series1 = JSONArray.fromObject(sumData);
		System.out.println(series1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("legend", legend);
		map.put("series", series);
		map.put("series1", series1);
		ju.getJsonByMap(map);
		return ju.getJsonByMap(map);
	}

	@Override
	public JSONObject getIndentPieData() {
		List<Indent> dataList = eChartDao.getIndentData();
		/* 把订单地址封装到数组中 */
		String legend[] = new String[dataList.size()];
		for (int i = 0; i <= dataList.size() - 1; i++) {
			legend[i] = dataList.get(i).getOrder_adress();
		}
		System.out.println(legend);

		/* 把订单信息封装到集合中转成json */
		List<EChartPie> amountData = new ArrayList<EChartPie>();
		for (int j = 0; j <= dataList.size() - 1; j++) {
			EChartPie pie = new EChartPie();
			pie.setValue(dataList.get(j).getOrder_amount());
			pie.setName(dataList.get(j).getOrder_adress());
			amountData.add(pie);
		}
		JSONArray series = JSONArray.fromObject(amountData);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("legend", legend);
		map.put("series", series);
		return ju.getJsonByMap(map);
	}

	@Override
	public JSONObject getAreaPieData(int dataIndex) {
		String area = Area.getInstance(dataIndex);
		System.out.println(area);
		List<Product> dataList = eChartDao.getAreaData(area);
		/* 把产品名字封装到数组中 */
		String legend[] = new String[dataList.size()];
		for (int i = 0; i <= dataList.size() - 1; i++) {
			legend[i] = dataList.get(i).getProduct_name();
		}
		System.out.println(legend);
		/* 把各地区销售封装到集合中转成json */
		List<EChartPie> amountData = new ArrayList<EChartPie>();
		for (int j = 0; j <= dataList.size() - 1; j++) {
			EChartPie pie = new EChartPie();
			pie.setValue(dataList.get(j).getProduct_stock());
			pie.setName(dataList.get(j).getProduct_name());
			amountData.add(pie);
			System.out.println("pie" + pie.getName());
		}
		JSONArray series = JSONArray.fromObject(amountData);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("legend", legend);
		map.put("series", series);
		return ju.getJsonByMap(map);
	}

	@Override
	public JSONObject geBarData() {
		List<String> legendList = new ArrayList<String>();
		legendList.add("2013");
		legendList.add("2014");
		legendList.add("2015");
		String legend[] = new String[legendList.size()];
		for (int i = 0; i <= legendList.size() - 1; i++) {
			legend[i] = legendList.get(i);
		}
		List<String> xAxisList = new ArrayList<String>();
		xAxisList.add("1月");
		xAxisList.add("2月");
		xAxisList.add("3月");
		xAxisList.add("4月");
		xAxisList.add("5月");
		xAxisList.add("6月");
		xAxisList.add("7月");
		xAxisList.add("8月");
		xAxisList.add("9月");
		xAxisList.add("10月");
		xAxisList.add("11月");
		xAxisList.add("12月");
		String xAxis[] = new String[xAxisList.size()];
		for (int i = 0; i <= xAxisList.size() - 1; i++) {
			xAxis[i] = xAxisList.get(i);
		}

		List<Profit> profitList13 = eChartDao.getProfitData13();
		int series13[] = new int[profitList13.size()];
		for (int i = 0; i <= profitList13.size() - 1; i++) {
			series13[i] = profitList13.get(i).getProfit();
		}

		List<Profit> profitList14 = eChartDao.getProfitData14();
		int series14[] = new int[profitList14.size()];
		for (int i = 0; i <= profitList14.size() - 1; i++) {
			series14[i] = profitList14.get(i).getProfit();
		}
		List<Profit> profitList15 = eChartDao.getProfitData15();
		int series15[] = new int[profitList15.size()];
		for (int i = 0; i <= profitList15.size() - 1; i++) {
			series15[i] = profitList15.get(i).getProfit();
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("legend", legend);
		map.put("xAxis", xAxis);
		map.put("series13", series13);
		map.put("series14", series14);
		map.put("series15", series15);
		return ju.getJsonByMap(map);
	}

	public EChartDao geteChartDao() {
		return eChartDao;
	}

	public void seteChartDao(EChartDao eChartDao) {
		this.eChartDao = eChartDao;
	}

}
