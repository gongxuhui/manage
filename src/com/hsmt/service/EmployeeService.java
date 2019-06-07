package com.hsmt.service;

import com.hsmt.entity.Employee;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface EmployeeService {
	/* ����id��ѯ����Ա����Ϣ */
	public JSONObject getAllEmplById(int id, int page, int rows);

	/* ����û���Ϣ */
	public int addEmpl(Employee employee);

	/* �޸��û���Ϣ */
	public int editEmpl(Employee employee);

	/* ɾ���û���Ϣ */
	public int delEmpl(String did);

	/* ��ѯ�û���Ϣ�Ĳ��� */
	public JSONArray getEmpl(String sid, String emp_hiredate, String emp_hiredate1);

	/* ����excle */
	  public void getExcel(String url, String excleName);
	 

}