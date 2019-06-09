package com.hsmt.util;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jfree.data.general.DefaultPieDataset;

import com.hsmt.entity.TMenu;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DbUtil {
	private static ComboPooledDataSource ds;
	//mysql c3p0程序驱动
	static {
		ds = new ComboPooledDataSource();
		Properties pro = new Properties();
		try {
			pro.load(DbUtil.class.getResourceAsStream("/db.properties"));
			ds.setDriverClass(pro.getProperty("c3p0.driver"));
			ds.setJdbcUrl(pro.getProperty("c3p0.url"));
			ds.setUser(pro.getProperty("c3p0.user"));
			ds.setPassword(pro.getProperty("c3p0.password"));
			ds.setMaxPoolSize(Integer.parseInt(pro.getProperty("c3p0.maxpool")));
			ds.setMinPoolSize(Integer.parseInt(pro.getProperty("c3p0.minpool")));
		} catch (IOException e) {
			System.out.println(e);
		} catch (PropertyVetoException e) {
			System.out.println(e);
		}
	}

	/**
	 * 获取数据库连接
	 * @return
	 */
	public Connection getConnection() {
		try {
			return (Connection) ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int runSQL(String sql) {
		Connection conn = getConnection();
		int a = 0;
		Statement stmt = null;
		try {
			stmt = (Statement) conn.createStatement();
			a = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(null, stmt, conn);
		}
		return a;
	}

	public int count(String sql) {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, conn);
		}
		return 0;
	}


	public ResultSet find(String sql) {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, conn);
		}
		return rs;
	}


	public int getChild(int id) {
		Connection conn = getConnection();
		TMenu tMenu = null;
		ResultSet rs = null;
		Statement stmt = null;
		List<TMenu> listTMenu = new ArrayList<TMenu>();
		int len = 0;
		try {
			String sql = "";
			if (id == 0) {
				sql = "select * from t_menu where pid = 999";
			} else {
				sql = "select * from t_menu where pid = " + id;
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				tMenu = new TMenu();
				tMenu.setId(rs.getInt("id"));
				tMenu.setText(rs.getString("text"));
				tMenu.setPid(rs.getInt("pid"));
				tMenu.setState(rs.getString("state"));
				listTMenu.add(tMenu);
			}
			len = listTMenu.size();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, conn);
		}
		return len;
	}

	public DefaultPieDataset dataConversion(String sql) {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		double[][] table = null;
		String[] name = null;
		String[] number = null;
		int result = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.last()) {
				result = rs.getRow();
				rs.beforeFirst();
			}
			table = new double[result][rs.getMetaData().getColumnCount() - 1];
			name = new String[result];
			number = new String[rs.getMetaData().getColumnCount() - 1];
			rs.next();
			for (int j = 0; j < rs.getMetaData().getColumnCount() - 1; j++) {
				number[j] = rs.getMetaData().getColumnName(j + 2);
			}
			int i = 0;
			rs.beforeFirst();
			while (rs.next()) {
				name[i] = rs.getString(1);
				for (int j = 0; j < rs.getMetaData().getColumnCount() - 1; j++)
					table[i][j] = rs.getDouble(j + 2);
				i++;
			}
		} catch (Exception ex) {
			System.err.println("Exception:" + ex.getMessage());
		} finally {
			close(rs, stmt, conn);
		}
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (int i = 0; i < number.length; i++)
			for (int j = 0; j < result; j++) {
				dataset.setValue(name[j], table[j][i]);
				System.out.println(table[j][i]);
				System.out.println(name[j]);
				System.out.println(dataset);
			}
		return dataset;
	}

	public List<String> getCellName(String sql) {
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		List<String> listCell = new ArrayList<String>();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData data = rs.getMetaData();
			if (rs.next()) {
				for (int i = 1; i <= data.getColumnCount(); i++) {
					int columnCount = data.getColumnCount();
					String columnName = data.getColumnName(i);
					listCell.add(columnName);
					System.out.println(columnCount);
					System.out.println(columnName);
					System.out.println(listCell.size());
					System.out.println(listCell.get(0));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, stmt, conn);
		}
		return listCell;
	}

	/**
	 * 关闭程序
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public void close(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (null != rs)
				rs.close();
		} catch (Exception ex) {

		}
		try {
			if (null != stmt)
				stmt.close();
		} catch (Exception ex) {

		}
		try {
			if (null != conn)
				conn.close();
		} catch (Exception ex) {
		}
	}
}
