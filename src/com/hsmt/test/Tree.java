/*package com.hsmt.test;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.hsmt.entity.Menu;

import net.sf.json.JSONArray;

public class Tree {
	private int id;
	Menu menu1 = new Menu();
	HttpServletResponse response = null;
	public void getTree(){
		menu1.setId(1);
		menu1.setText("ssss");
		try {
			response.getWriter().print(JSONArray.fromObject(menu1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		System.out.println(id);
		this.id = id;
	}
}
*/