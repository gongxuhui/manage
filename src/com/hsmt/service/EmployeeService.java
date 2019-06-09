package com.hsmt.service;

import com.hsmt.entity.Employee;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface EmployeeService {
	public JSONObject getAllEmplById(int id, int page, int rows);

	public int addEmpl(Employee employee);

	public int editEmpl(Employee employee);

	public int delEmpl(String did);

	public JSONArray getEmpl(String sid, String emp_hiredate, String emp_hiredate1);

	public void getExcel(String url, String excleName);
	 

}