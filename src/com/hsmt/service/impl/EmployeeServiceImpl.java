package com.hsmt.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hsmt.dao.EmployeeDao;
import com.hsmt.entity.Employee;
import com.hsmt.service.EmployeeService;
import com.hsmt.util.DbUtil;
import com.hsmt.util.HyUtil;
import com.hsmt.util.JsonUtil;
import com.hsmt.util.RandomUtil;
import com.hsmt.util.SaveUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EmployeeServiceImpl implements EmployeeService {
	Logger logger = Logger.getLogger("EmployeeServiceImpl");
	JsonUtil ju = new JsonUtil();
	SaveUtil su = new SaveUtil();
	DbUtil db = new DbUtil();
	HyUtil hy = new HyUtil();
	RandomUtil ru = new RandomUtil();
	private EmployeeDao employeeDao;

	@Override
	public JSONObject getAllEmplById(int id, int page, int rows) {
		Map<String, Object> jsonMap = new HashMap<String, Object>();
		List<Employee> list;
		try {
			int total = employeeDao.getTotalById(id);
			list = employeeDao.findAllById(id, page, rows);
			jsonMap.put("total", total);
			jsonMap.put("rows", list);
		} catch (Exception e) {
		}
		return ju.getJsonByMap(jsonMap);
	}

	@Override
	public int addEmpl(Employee employee) {
		int num = Integer.parseInt(ru.getFixLenthString(6));
		String firstSpell = hy.cn2FirstSpell(employee.getEmpName());
		String empId = firstSpell + num;
		employee.setEmpId(empId);
		int result = 0;
		try {
			result = employeeDao.addEmpl(employee);
		} catch (Exception e) {
		}
		return result;
	}

	@Override
	public int editEmpl(Employee employee) {
		int result = 0;
		try {
			result = employeeDao.editEmpl(employee);
		} catch (Exception e) {
		}
		return result;
	}

	@Override
	public int delEmpl(String did) {
		int result = 0;
		try {
			result = employeeDao.delEmpl(did);
		} catch (Exception e) {
		}
		return result;
	}

	@Override
	public JSONArray getEmpl(String sid, String shiredate, String shiredate1) {

		return ju.getJsonByList(employeeDao.find(sid, shiredate, shiredate1));
	}

	@Override
	public void getExcel(String url, String excleName) {
		List<List<String>> listData = employeeDao.listDate();
		su.exportExcle(url, excleName, listData);
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

}
