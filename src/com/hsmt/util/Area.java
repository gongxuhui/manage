package com.hsmt.util;

public enum Area {
	华东地区(0, "华东地区"), 华北地区(1, "华北地区"), 华南地区(2, "华南地区"), 华西地区(3, "华西地区");
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
		throw new IllegalArgumentException("status值非法，没有符合的枚举对象");
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
