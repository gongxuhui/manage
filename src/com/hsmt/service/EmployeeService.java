package com.hsmt.service;

import com.hsmt.entity.Employee;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface EmployeeService {
	/* 根据id查询所有员工信息 */
	public JSONObject getAllEmplById(int id, int page, int rows);

	/* 添加用户信息 */
	public int addEmpl(Employee employee);

	/* 修改用户信息 */
	public int editEmpl(Employee employee);

	/* 删除用户信息 */
	public int delEmpl(String did);

	/* 查询用户信息的操作 */
	public JSONArray getEmpl(String sid, String emp_hiredate, String emp_hiredate1);

	/* 生成excle */
	  public void getExcel(String url, String excleName);
	 

}