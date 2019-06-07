package com.hsmt.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
	Logger logger = Logger.getLogger("JsonUtil");

	/* 把List数组转化成json */
	public JSONArray getJsonByList(List<?> list) {
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONArray jsonArray = JSONArray.fromObject(list);
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(jsonArray.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error("json工具类中list转json时出现异常-->", e);
		}
		return jsonArray;
	}

	/* 把已经封装好数据map集合转化为json */
	public JSONObject getJson() {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", "保存成功");
		map.put("msg", "操作错误");
		JSONObject jsonMap = JSONObject.fromObject(map);
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(jsonMap.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error("json工具类中固定map转json时出现异常-->", e);
		}
		return jsonMap;
	}

	/* 把map集合转化为json */
	public JSONObject getJsonByMap(Map<String, Object> map) {
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONObject jsonMap = JSONObject.fromObject(map);
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(jsonMap.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error("json工具类中map转json时出现异常-->", e);
		}
		return jsonMap;
	}

	/* 把map集合转化为json */
	public JSONObject getJsonByMap1(Map<String, Object> map) {
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONObject jsonMap = JSONObject.fromObject(map);
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(jsonMap.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonMap;
	}
}
