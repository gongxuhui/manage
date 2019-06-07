package com.hsmt.dao;

import java.util.List;

import com.hsmt.entity.Box;

public interface BoxDao {
	/* 获取部门的下拉框数据 */
	public List<Box> findGroupBox();

	/* 获取地区的下拉框数据 */
	public List<Box> findAreaBox();

	/* 获取等级的下拉框数据 */
	public List<Box> findLevelBox();
}
