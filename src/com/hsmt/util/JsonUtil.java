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

	/**
	 * list转json
	 * @param list
	 * @return
	 */
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
			logger.error("list转json--->", e);
		}
		return jsonArray;
	}

	/**
	 * map转json
	 * @return
	 */
	public JSONObject getJson() {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", "成功");
		map.put("msg", "失败");
		JSONObject jsonMap = JSONObject.fromObject(map);
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(jsonMap.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error("--->", e);
		}
		return jsonMap;
	}

	/**
	 * map转json
	 * @param map
	 * @return
	 */
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
			logger.error("map转json--->", e);
		}
		return jsonMap;
	}

	/**
	 * map转json
	 * @param map
	 * @return
	 */
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
