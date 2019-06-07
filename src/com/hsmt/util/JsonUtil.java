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

	/* ��List����ת����json */
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
			logger.error("json��������listתjsonʱ�����쳣-->", e);
		}
		return jsonArray;
	}

	/* ���Ѿ���װ������map����ת��Ϊjson */
	public JSONObject getJson() {
		HttpServletResponse response = ServletActionContext.getResponse();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", "����ɹ�");
		map.put("msg", "��������");
		JSONObject jsonMap = JSONObject.fromObject(map);
		response.setCharacterEncoding("utf-8");
		try {
			PrintWriter writer = response.getWriter();
			writer.write(jsonMap.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			logger.error("json�������й̶�mapתjsonʱ�����쳣-->", e);
		}
		return jsonMap;
	}

	/* ��map����ת��Ϊjson */
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
			logger.error("json��������mapתjsonʱ�����쳣-->", e);
		}
		return jsonMap;
	}

	/* ��map����ת��Ϊjson */
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
