package com.hsmt.dao;

import java.util.List;

import com.hsmt.entity.Employee;

public interface EmployeeDao {
	/* 查询用户总数的操作 */
	public int getTotalById(int id);

	/* 查询员工信息操作 */
	public List<Employee> findAllById(int id, int page, int rows);

	/* 添加员工信息的操作 */
	public int addEmpl(Employee employee);

	/* 修改员工信息的操作 */
	public int editEmpl(Employee employee);

	/* 删除员工信息的操作 */
	public int delEmpl(int id);

	/* 查询指定员工的操作 */
	public List<Employee> find(String sid, String emp_hiredate, String emp_hiredate1);

	/* 获取excle中的数据 */
	public List<List<String>> listDate();
}
