package com.hsmt.dao;

import java.util.List;

import com.hsmt.entity.Employee;

public interface EmployeeDao {
	/* ��ѯ�û������Ĳ��� */
	public int getTotalById(int id);

	/* ��ѯԱ����Ϣ���� */
	public List<Employee> findAllById(int id, int page, int rows);

	/* ���Ա����Ϣ�Ĳ��� */
	public int addEmpl(Employee employee);

	/* �޸�Ա����Ϣ�Ĳ��� */
	public int editEmpl(Employee employee);

	/* ɾ��Ա����Ϣ�Ĳ��� */
	public int delEmpl(int id);

	/* ��ѯָ��Ա���Ĳ��� */
	public List<Employee> find(String sid, String emp_hiredate, String emp_hiredate1);

	/* ��ȡexcle�е����� */
	public List<List<String>> listDate();
}
