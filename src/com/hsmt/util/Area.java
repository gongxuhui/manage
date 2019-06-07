package com.hsmt.util;

public enum Area {
	��������(0, "��������"), ��������(1, "��������"), ���ϵ���(2, "���ϵ���"), ��������(3, "��������");
	private int value;
	private String name;

	private Area(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getInstance(int i) {
		Area[] allStatus = Area.values();
		for (Area ws : allStatus) {
			if (ws.getValue() == i) {
				return ws.getName();
			}
			
		}
		throw new IllegalArgumentException("statusֵ�Ƿ���û�з��ϵ�ö�ٶ���");
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
