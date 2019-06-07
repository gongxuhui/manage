package com.hsmt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsmt.dao.BoxDao;
import com.hsmt.entity.Box;
import com.hsmt.util.DbUtil;

public class BoxDaoImpl implements BoxDao {
	DbUtil db = new DbUtil();
	Box box = null;

	@Override
	public List<Box> findGroupBox() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Box> boxList = new ArrayList<Box>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT g.`value_field`,g.`text_field` FROM groupbox g;";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				box = new Box();
				box.setValueField(rs.getString("value_field"));
				box.setTextField(rs.getString("text_field"));
				boxList.add(box);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return boxList;
	}

	@Override
	public List<Box> findAreaBox() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Box> boxList = new ArrayList<Box>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT a.`value_field`,a.`text_field` FROM areabox a;";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				box = new Box();
				box.setValueField(rs.getString("value_field"));
				box.setTextField(rs.getString("text_field"));
				boxList.add(box);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return boxList;
	}

	@Override
	public List<Box> findLevelBox() {
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<Box> boxList = new ArrayList<Box>();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT l.`value_field`,l.`text_field` FROM levelbox l;";
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				box = new Box();
				box.setValueField(rs.getString("value_field"));
				box.setTextField(rs.getString("text_field"));
				boxList.add(box);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return boxList;
	}

}
