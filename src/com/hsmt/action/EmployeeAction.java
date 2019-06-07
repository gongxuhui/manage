package com.hsmt.action;

import org.apache.log4j.Logger;

import com.hsmt.entity.Employee;
import com.hsmt.service.EmployeeService;
import com.hsmt.util.JsonUtil;
import com.opensymphony.xwork2.ModelDriven;

public class EmployeeAction implements ModelDriven<Employee> {
	Logger logger = Logger.getLogger("EmployeeAction");
	private int id;// 查询所用员工时所用的id
	private String did;// 删除员工信息所用的did
	private EmployeeService employeeService;
	private Employee employee = new Employee();
	private String sid;// 查询时所用的sid
	private String shiredate;// 查询时所用的日期时间
	private String shiredate1;
	private int page;// 页
	private int rows;// 行

	/* 根据id查询所有的员工信息 */
	public void searchAll() {
		try {
			employeeService.getAllEmplById(id, page, rows);
		} catch (Exception e) {
			logger.error("action层查询所有员工时出现异常", e);
		}
		logger.info("action层查询员工信息时所需的树节点id+" + id);
	}

	/* 添加员工信息 */
	public void add() {
		int i = 0;
		try {
			i = employeeService.addEmpl(employee);
		} catch (Exception e) {
			logger.error("action层添加员工时出现异常", e);
		}
		if (i == 1) {
			JsonUtil ju = new JsonUtil();
			ju.getJson();
		} else {
			System.out.println("错误信息");
		}
		logger.info("action中添加员工信息时所需的员工姓名-->" + employee.getEmpName());
	}

	/* 编辑员工信息 */
	public void edit() {
		int i = 0;
		try {
			i = employeeService.editEmpl(employee);
		} catch (Exception e) {
			logger.error("Action层中修改员工时出现異常", e);
		}
		if (i == 1) {
			JsonUtil ju = new JsonUtil();
			ju.getJson();
		} else {
			System.out.println("错误信息");
		}
		logger.info("action中编辑员工信息时所需的employee-->" + employee);
	}

	/* 删除员工信息 */
	public void del() {
		System.out.println("++++=" + did);
		int i = 0;
		try {
			i = employeeService.delEmpl(did);
		} catch (Exception e) {
			logger.error("action层删除员工时出现异常", e);
		}
		if (i == 1) {
			JsonUtil ju = new JsonUtil();
			ju.getJson();
		} else {
			System.out.println("错误信息");
		}
		logger.info("action中添加员工信息时所需的did+" + did);
	}

	/* 指定信息查询员工信息 */
	public void search() {
		try {
			employeeService.getEmpl(sid, shiredate, shiredate1);
		} catch (Exception e) {
			logger.error("action层指定信息查询所用员工时出现异常", e);
		}
		System.out.println(employeeService.getEmpl(sid, shiredate, shiredate1));
		System.out.println("天才" + sid);
		logger.info("action中指定信息查询员工信息时所需的sid和shiredate+" + sid + shiredate);
	}

	/* 导出excle */
	public void getExcle() {
		String url = "E:/Excel/ExcelDemo";
		String excleName = "/ggg.xls";
		employeeService.getExcel(url, excleName);
		logger.info("action中生成excle路径名+" + url);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getShiredate() {
		return shiredate;
	}

	public void setShiredate(String shiredate) {
		this.shiredate = shiredate;
	}

	public String getShiredate1() {
		return shiredate1;
	}

	public void setShiredate1(String shiredate1) {
		this.shiredate1 = shiredate1;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	@Override
	public Employee getModel() {
		return employee;
	}

}
