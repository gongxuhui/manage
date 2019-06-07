package com.hsmt.dao;

import java.util.List;

import com.hsmt.entity.Box;

public interface BoxDao {
	/* ��ȡ���ŵ����������� */
	public List<Box> findGroupBox();

	/* ��ȡ���������������� */
	public List<Box> findAreaBox();

	/* ��ȡ�ȼ������������� */
	public List<Box> findLevelBox();
}
