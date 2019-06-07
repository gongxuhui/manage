package com.hsmt.dao;

import java.util.List;

import com.hsmt.entity.PMenu;

public interface TreeDao {
	/*员工信息左侧树的实现*/
	public List<PMenu> getRootById(int id);
	/*产品信息左侧树的实现*/
	public List<PMenu>getProductRootById(int id);
}
