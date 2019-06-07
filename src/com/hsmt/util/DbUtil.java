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
	/* mysql数据库驱动加载程序 */
	static {
		ds = new ComboPooledDataSource();
		/* 加载属性文件，读取数据库的连接信息 */
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

	/* 创建数据库连接，获得connection对象 */
	public Connection getConnection() {
		try {
			return (Connection) ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/* 创建一个创建一个Statement对象，要执行SQL语句，必须获得java.sql.Statement实例 */
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

	/* 得到数据的第一列元素可以根据索引 也可以根据列名 */
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

	/* 查询一条数据 返回ResultSet */
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

	/* 根据节点判断是否有子节点 */
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

	/* 从数据库获取信息然后转化成对应图表的数据 */
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
			// 取得行数
			if (rs.last()) {
				result = rs.getRow();
				rs.beforeFirst(); // 指针回滚
			}
			table = new double[result][rs.getMetaData().getColumnCount() - 1];// 定义存放数据的二维数组
			name = new String[result];
			number = new String[rs.getMetaData().getColumnCount() - 1]; // 定义存放数据表头的一维数组
			rs.next();
			for (int j = 0; j < rs.getMetaData().getColumnCount() - 1; j++) {
				number[j] = rs.getMetaData().getColumnName(j + 2); // 取出表头并存放数组
			}
			int i = 0;
			rs.beforeFirst();
			while (rs.next()) {
				name[i] = rs.getString(1);
				for (int j = 0; j < rs.getMetaData().getColumnCount() - 1; j++)
					table[i][j] = rs.getDouble(j + 2); // 取出数据并存入二维数组
				i++;
			}
		} catch (Exception ex) {
			System.err.println("Exception:" + ex.getMessage());
		} finally {
			close(rs, stmt, conn);
		}
		// 创建DefaultPieDataset类型的数据集，并行数据集中添加数据（从数据库中取的数据）
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (int i = 0; i < number.length; i++)
			for (int j = 0; j < result; j++) {
				dataset.setValue(name[j], table[j][i]);
				// 调试用
				System.out.println(table[j][i]);
				System.out.println(name[j]);
				System.out.println(dataset);
			}
		return dataset;
	}

	/* 动态获取数据库的列名 */
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
					/* 获得所有列的数目及实际列数 */
					int columnCount = data.getColumnCount();
					/* 获得指定列的列名 */
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

	/* 关闭数据库连接操作 */
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
