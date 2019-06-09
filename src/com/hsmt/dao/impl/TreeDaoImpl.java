package com.hsmt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsmt.dao.TreeDao;
import com.hsmt.entity.PMenu;
import com.hsmt.entity.TMenu;
import com.hsmt.util.DbUtil;

import freemarker.log.Logger;

public class TreeDaoImpl implements TreeDao {
	Logger logger = Logger.getLogger("TreeDaoImpl");
	TMenu tMenu = null;
	PMenu pMenu = null;
	ResultSet rs = null;
	Statement stmt = null;
	Connection conn = null;
	DbUtil db = new DbUtil();
	List<TMenu> listTMenu = null;
	List<PMenu> listPMenu = null;

	public List<PMenu> getRootById(int id) {
		conn = db.getConnection();
		listTMenu = new ArrayList<TMenu>();
		listPMenu = new ArrayList<PMenu>();
		try {
			stmt = conn.createStatement();
			String sql = "";
			if (id == 0) {
				sql = "select * from t_menu where pid =999 ";
			} else {
				sql = "select * from t_menu where pid = " + id;
			}
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				tMenu = new TMenu();
				tMenu.setId(rs.getInt("id"));
				tMenu.setText(rs.getString("text"));
				tMenu.setPid(rs.getInt("pid"));
				tMenu.setState(rs.getString("state"));
				listTMenu.add(tMenu);
			}
			for (TMenu tt : listTMenu) {
				pMenu = new PMenu();
				pMenu.setId(tt.getId());
				pMenu.setText(tt.getText());
				pMenu.setState(tt.getState());
				listPMenu.add(pMenu);
			}
		} catch (SQLException e) {
			logger.error("daoImpl���в�ѯ�ӽڵ����ݳ��ֵ��쳣-->", e);
		} finally {
			db.close(rs, stmt, conn);
		}
		logger.info("daoImpl���в�ѯ�ӽڵ�����listPMenu-->" + listPMenu);
		return listPMenu;
	}

	@Override
	public List<PMenu> getProductRootById(int id) {
		conn = db.getConnection();
		listTMenu = new ArrayList<TMenu>();
		listPMenu = new ArrayList<PMenu>();
		try {
			stmt = conn.createStatement();
			String sql = "";
			if (id == 0) {
				sql = "select * from product_tree where pid =99 ";
			} else {
				sql = "select * from product_tree where pid = " + id;
			}
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				tMenu = new TMenu();
				tMenu.setId(rs.getInt("id"));
				tMenu.setText(rs.getString("text"));
				tMenu.setPid(rs.getInt("pid"));
				tMenu.setState(rs.getString("state"));
				listTMenu.add(tMenu);
			}

			for (TMenu tt : listTMenu) {
				pMenu = new PMenu();
				pMenu.setId(tt.getId());
				pMenu.setText(tt.getText());
				pMenu.setState(tt.getState());
				listPMenu.add(pMenu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs, stmt, conn);
		}
		return listPMenu;
	}
}
