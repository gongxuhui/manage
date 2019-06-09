package com.hsmt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hsmt.dao.EChartDao;
import com.hsmt.entity.Employee;
import com.hsmt.entity.Indent;
import com.hsmt.entity.Product;
import com.hsmt.entity.Profit;
import com.hsmt.util.DbUtil;

public class EChartDaoImpl implements EChartDao {
	Logger logger = Logger.getLogger("EChartDaoImpl");
	DbUtil db = new DbUtil();

	@Override
	public List<Employee> getGroupData() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Employee employee = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT e.`emp_group`,COUNT(6) AS amount FROM employee e  GROUP BY e.`emp_group`;";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				employee = new Employee();
				employee.setEmpGroup(rs.getString("emp_group"));
				employee.setAmount(rs.getInt("amount"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			logger.error("", e);
		} finally {
			db.close(rs, stmt, conn);
		}
		return employeeList;
	}

	@Override
	public List<Employee> getSalaryData() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Employee employee = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT e.`emp_level`,AVG(e.`emp_salary`)AS averageSalary FROM employee e  GROUP BY emp_level;";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				employee = new Employee();
				employee.setEmpLevel(rs.getString("emp_level"));
				employee.setAverageSalary(rs.getInt("averageSalary"));
				employeeList.add(employee);
			}
			System.out.println(employeeList.size());
			System.out.println(employeeList.get(1).getEmpLevel());
			logger.info("dao获取薪水数据的sql-->" + sql);
		} catch (SQLException e) {
			logger.error("dao获取薪水数据时出现的异常-->", e);
		} finally {
			db.close(rs, stmt, conn);
		}
		return employeeList;
	}

	@Override
	public List<Employee> getGroupLevelData(String group) {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Employee employee = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT e.`emp_level`,COUNT(6) AS amount FROM employee e WHERE e.`emp_group`='" + group
					+ "' GROUP BY e.`emp_level`";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				employee = new Employee();
				employee.setEmpLevel(rs.getString("emp_level"));
				employee.setAmount(rs.getInt("amount"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return employeeList;
	}

	@Override
	public List<Product> getProductData() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			stmt = conn.createStatement();
			String sql = "select * from product";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				product = new Product();
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_stock(rs.getInt("product_stock"));
				product.setProduct_sum(rs.getInt("product_sum"));
				productList.add(product);
			}
		} catch (SQLException e) {
			logger.error("", e);
		} finally {
			db.close(rs, stmt, conn);
		}
		return productList;
	}

	@Override
	public List<Indent> getIndentData() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Indent indent = null;
		List<Indent> indentList = new ArrayList<Indent>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT i.`order_adress`AS adress,SUM(i.`order_amount`) AS amount FROM indent i GROUP BY i.`order_adress`";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				indent = new Indent();
				indent.setOrder_adress(rs.getString("adress"));
				indent.setOrder_amount(rs.getInt("amount"));
				indentList.add(indent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return indentList;
	}

	@Override
	public List<Product> getAreaData(String area) {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Product product = null;
		List<Product> productList = new ArrayList<Product>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT p.`product_name`,SUM(i.`order_amount`) AS amount FROM product p,indent i WHERE i.`order_adress`='"
					+ area + "'AND p.`product_id`=i.`product_id` GROUP BY p.`product_name`";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				product = new Product();
				product.setProduct_name(rs.getString("product_name"));
				product.setProduct_stock(rs.getInt("amount"));
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return productList;
	}

	@Override
	public List<Profit> getProfitData13() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Profit profit = null;
		List<Profit> profitList = new ArrayList<Profit>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT months,SUM(price*amount) AS profit FROM(SELECT p.`product_name`,p.`product_price`AS price ,i.`order_amount`AS amount,i.`order_date`, SUBSTRING(i.`order_date`,1,4) AS years, SUBSTRING(i.`order_date`,6,2) AS 'months' FROM product p,indent i WHERE i.`product_id`= p.`product_id`) profit "
					+ "WHERE years='2013' GROUP BY months ";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				profit = new Profit();
				profit.setProfit(rs.getInt("profit"));
				profitList.add(profit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return profitList;
	}

	@Override
	public List<Profit> getProfitData14() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Profit profit = null;
		List<Profit> profitList = new ArrayList<Profit>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT months,SUM(price*amount) AS profit FROM(SELECT p.`product_name`,p.`product_price`AS price ,i.`order_amount`AS amount,i.`order_date`, SUBSTRING(i.`order_date`,1,4) AS years, SUBSTRING(i.`order_date`,6,2) AS 'months' FROM product p,indent i WHERE i.`product_id`= p.`product_id`) profit "
					+ "WHERE years='2014' GROUP BY months";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				profit = new Profit();
				profit.setProfit(rs.getInt("profit"));
				profitList.add(profit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return profitList;
	}

	@Override
	public List<Profit> getProfitData15() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Profit profit = null;
		List<Profit> profitList = new ArrayList<Profit>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT months,SUM(price*amount) AS profit FROM(SELECT p.`product_name`,p.`product_price`AS price ,i.`order_amount`AS amount,i.`order_date`, SUBSTRING(i.`order_date`,1,4) AS years, SUBSTRING(i.`order_date`,6,2) AS 'months' FROM product p,indent i WHERE i.`product_id`= p.`product_id`) profit "
					+ "WHERE years='2015' GROUP BY months";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				profit = new Profit();
				profit.setProfit(rs.getInt("profit"));
				profitList.add(profit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return profitList;
	}

}
