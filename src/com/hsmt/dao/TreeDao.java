package com.hsmt.dao;

import java.util.List;

import com.hsmt.entity.PMenu;

public interface TreeDao {
	/*员工左侧树*/
	public List<PMenu> getRootById(int id);
	/*产品信息左侧树*/
	public List<PMenu>getProductRootById(int id);
}
