package com.hsmt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hsmt.dao.EmployeeDao;
import com.hsmt.entity.Employee;
import com.hsmt.util.DbUtil;

public class EmployeeDaoImpl implements EmployeeDao {
	Logger logger = Logger.getLogger("EmployeeDaoImpl");
	DbUtil db = new DbUtil();
	Employee employee = null;

	@Override
	public int getTotalById(int id) {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT e.`emp_id`,e.`emp_name`,e.`emp_age`,e.`emp_sex`,e.`emp_hiredate`,e.`emp_area`,e.`emp_level`,e.`emp_salary`,e.`emp_group`";
			if ((id == 1) || (id == 0)) {
				sql = sql + " FROM employee e;";
			} else {
				if (db.getChild(id) > 0) {
					sql = sql + " FROM employee e , t_menu t  WHERE t.`text` = e.`emp_group` AND t.`pid`=" + id;
				} else {
					sql = sql + " FROM employee e , t_menu t  WHERE t.`text` = e.`emp_group` AND t.`id`=" + id;

				}
			}
			logger.info("EmployeeDaoImpl获取数据总数时的sql-->" + sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				employee = new Employee();
				employee.setEmpId(rs.getString("emp_id"));
				employee.setEmpName(rs.getString("emp_name"));
				employee.setEmpAge(rs.getInt("emp_age"));
				employee.setEmpSex(rs.getString("emp_sex"));
				employee.setEmpHiredate(rs.getString("emp_hiredate"));
				employee.setEmpArea(rs.getString("emp_area"));
				employee.setEmpLevel(rs.getString("emp_level"));
				employee.setEmpSalary(rs.getInt("emp_salary"));
				employee.setEmpGroup(rs.getString("emp_group"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			logger.error("EmployeeDaoImpl获取数据总数时出现的异常-->", e);
		} finally {
			db.close(rs, stmt, conn);
		}
		int totle = employeeList.size();
		return totle;
	}

	@Override
	public List<Employee> findAllById(int id, int page, int rows) {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		int index = (page - 1) * rows;
		try {
			stmt = conn.createStatement();
			String sql = "SELECT e.`emp_id`,e.`emp_name`,e.`emp_age`,e.`emp_sex`,e.`emp_hiredate`,e.`emp_area`,e.`emp_level`,e.`emp_salary`,e.`emp_group`";
			if ((id == 1) || (id == 0)) {
				sql = sql + " FROM employee e  LIMIT " + index + "," + rows;
			} else {
				if (db.getChild(id) > 0) {
					sql = sql + " FROM employee e , t_menu t  WHERE t.`text` = e.`emp_group` AND t.`pid`=" + id
							+ " LIMIT " + index + "," + rows;
				} else {
					sql = sql + " FROM employee e , t_menu t  WHERE t.`text` = e.`emp_group` AND t.`id`=" + id
							+ " LIMIT " + index + "," + rows;
				}
			}
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				employee = new Employee();
				employee.setEmpId(rs.getString("emp_id"));
				employee.setEmpName(rs.getString("emp_name"));
				employee.setEmpAge(rs.getInt("emp_age"));
				employee.setEmpSex(rs.getString("emp_sex"));
				employee.setEmpHiredate(rs.getString("emp_hiredate"));
				employee.setEmpArea(rs.getString("emp_area"));
				employee.setEmpLevel(rs.getString("emp_level"));
				employee.setEmpSalary(rs.getInt("emp_salary"));
				employee.setEmpGroup(rs.getString("emp_group"));
				employeeList.add(employee);
			}
		} catch (SQLException e) {
			logger.error("dao数据分页时出现的异常-->", e);
		} finally {
			db.close(rs, stmt, conn);
		}
		return employeeList;
	}

	@Override
	public int addEmpl(Employee employee) {
		Connection conn = db.getConnection();
		Statement stmt = null;
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = "insert into employee(emp_id,emp_name,emp_age,emp_sex,emp_hiredate,emp_area,emp_level,emp_salary,emp_group)values('"
					+ employee.getEmpId() + "','" + employee.getEmpName() + "'," + employee.getEmpAge() + ",'"
					+ employee.getEmpSex() + "','" + employee.getEmpHiredate() + "','" + employee.getEmpArea() + "','"
					+ employee.getEmpLevel() + "'," + employee.getEmpSalary() + ",'" + employee.getEmpGroup() + "')";
			result = stmt.executeUpdate(sql);
			logger.info("EmployeeDaoImpl添加员工数据时的sql-->" + sql);
		} catch (SQLException e) {
			logger.error("EmployeeDaoImpl添加员工数据时出现的异常-->", e);
		} finally {
			db.close(null, stmt, conn);
		}
		return result;
	}

	@Override
	public int editEmpl(Employee employee) {
		Connection conn = db.getConnection();
		Statement stmt = null;
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = "UPDATE employee e SET e.`emp_name`='" + employee.getEmpName() + "',e.`emp_age`="
					+ employee.getEmpAge() + ",e.`emp_sex`='" + employee.getEmpSex() + "',e.`emp_hiredate`='"
					+ employee.getEmpHiredate() + "' ,e.`emp_level`='" + employee.getEmpLevel() + "' ,e.`emp_area`='"
					+ employee.getEmpArea() + "',e.`emp_salary`=" + employee.getEmpSalary() + ",e.`emp_group`= '"
					+ employee.getEmpGroup() + "'  WHERE  e.`emp_id`='" + employee.getEmpId() + "'";
			result = stmt.executeUpdate(sql);
			logger.info("dao编辑员工数据时的sql-->" + sql);
		} catch (SQLException e) {
			logger.error("dao编辑员工数据时出现的异常-->", e);
		} finally {
			db.close(null, stmt, conn);
		}
		return result;
	}

	@Override
	public int delEmpl(String id) {
		Connection conn = db.getConnection();
		Statement stmt = null;
		int result = 0;
		try {
			stmt = conn.createStatement();
			String sql = "delete from employee where emp_id= '" + id+"'";
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			logger.error("dao删除员工数据时出现的异常-->", e);
		} finally {
			db.close(null, stmt, conn);
		}
		return result;
	}

	@Override
	public List<Employee> find(String sid, String shiredate, String shiredate1) {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Employee> employeeList = new ArrayList<Employee>();
		System.out.println(sid);
		System.out.println(shiredate);
		try {
			stmt = conn.createStatement();
			String sql = "SELECT e.`emp_id`,e.`emp_name`,e.`emp_age`,e.`emp_sex`,e.`emp_hiredate`,e.`emp_area`,e.`emp_level`,e.`emp_salary`,e.`emp_group` FROM employee e";
			if (sid != null && !sid.equals("")) {
				sql = sql + " where e.`emp_id` like'%" + sid + "%'";
				if (shiredate != null && !shiredate.equals("")) {
					sql = sql + " and e.`emp_hiredate` BETWEEN'" + shiredate + "'and'" + shiredate1 + "'";
				} else {
					sql = sql + "";
				}
			} else {
				sql = sql + "";
				if (shiredate != null && !shiredate.equals("")) {
					sql = sql + " where  e.`emp_hiredate` BETWEEN'" + shiredate + "'and'" + shiredate1 + "'";
				} else {
					sql = sql + "";
				}
			}
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				employee = new Employee();
				employee.setEmpId(rs.getString("emp_id"));
				employee.setEmpName(rs.getString("emp_name"));
				employee.setEmpAge(rs.getInt("emp_age"));
				employee.setEmpSex(rs.getString("emp_sex"));
				employee.setEmpHiredate(rs.getString("emp_hiredate"));
				employee.setEmpLevel(rs.getString("emp_level"));
				employee.setEmpArea(rs.getString("emp_area"));
				employee.setEmpSalary(rs.getInt("emp_salary"));
				employee.setEmpGroup(rs.getString("emp_group"));
				employeeList.add(employee);
			}
		} catch (

		SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return employeeList;
	}

	@Override
	public List<List<String>> listDate() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<List<String>> employeeList = new ArrayList<List<String>>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT e.`emp_id`,e.`emp_name`,e.`emp_age`,e.`emp_sex`,e.`emp_hiredate`,e.`emp_area`,e.`emp_level`,e.`emp_salary`,e.`emp_group` FROM employee e";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				List<String> list = new ArrayList<String>();
				list.add("" + rs.getString("emp_id"));
				list.add("" + rs.getString("emp_name"));
				list.add("" + rs.getInt("emp_age"));
				list.add("" + rs.getString("emp_sex"));
				list.add("" + rs.getString("emp_hiredate"));
				list.add("" + rs.getString("emp_area"));
				list.add("" + rs.getString("emp_level"));
				list.add("" + rs.getInt("emp_salary"));
				list.add("" + rs.getString("emp_group"));
				employeeList.add(list);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return employeeList;
	}

}
