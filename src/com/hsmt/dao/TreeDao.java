package com.hsmt.dao;

import java.util.List;

import com.hsmt.entity.PMenu;

public interface TreeDao {
	/*Ա����Ϣ�������ʵ��*/
	public List<PMenu> getRootById(int id);
	/*��Ʒ��Ϣ�������ʵ��*/
	public List<PMenu>getProductRootById(int id);
}
