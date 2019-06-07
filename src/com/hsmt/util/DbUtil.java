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
	/* mysql���ݿ��������س��� */
	static {
		ds = new ComboPooledDataSource();
		/* ���������ļ�����ȡ���ݿ��������Ϣ */
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

	/* �������ݿ����ӣ����connection���� */
	public Connection getConnection() {
		try {
			return (Connection) ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* ����һ������һ��Statement����Ҫִ��SQL��䣬������java.sql.Statementʵ�� */
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

	/* �õ����ݵĵ�һ��Ԫ�ؿ��Ը������� Ҳ���Ը������� */
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

	/* ��ѯһ������ ����ResultSet */
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

	/* ���ݽڵ��ж��Ƿ����ӽڵ� */
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

	/* �����ݿ��ȡ��ϢȻ��ת���ɶ�Ӧͼ������� */
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
			// ȡ������
			if (rs.last()) {
				result = rs.getRow();
				rs.beforeFirst(); // ָ��ع�
			}
			table = new double[result][rs.getMetaData().getColumnCount() - 1];// ���������ݵĶ�ά����
			name = new String[result];
			number = new String[rs.getMetaData().getColumnCount() - 1]; // ���������ݱ�ͷ��һά����
			rs.next();
			for (int j = 0; j < rs.getMetaData().getColumnCount() - 1; j++) {
				number[j] = rs.getMetaData().getColumnName(j + 2); // ȡ����ͷ���������
			}
			int i = 0;
			rs.beforeFirst();
			while (rs.next()) {
				name[i] = rs.getString(1);
				for (int j = 0; j < rs.getMetaData().getColumnCount() - 1; j++)
					table[i][j] = rs.getDouble(j + 2); // ȡ�����ݲ������ά����
				i++;
			}
		} catch (Exception ex) {
			System.err.println("Exception:" + ex.getMessage());
		} finally {
			close(rs, stmt, conn);
		}
		// ����DefaultPieDataset���͵����ݼ����������ݼ���������ݣ������ݿ���ȡ�����ݣ�
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (int i = 0; i < number.length; i++)
			for (int j = 0; j < result; j++) {
				dataset.setValue(name[j], table[j][i]);
				// ������
				System.out.println(table[j][i]);
				System.out.println(name[j]);
				System.out.println(dataset);
			}
		return dataset;
	}

	/* ��̬��ȡ���ݿ������ */
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
					/* ��������е���Ŀ��ʵ������ */
					int columnCount = data.getColumnCount();
					/* ���ָ���е����� */
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

	/* �ر����ݿ����Ӳ��� */
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
