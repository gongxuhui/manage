package com.hsmt.util;

public enum Group {
	人事行政组(0, "人事行政组"), 共享开发组(1, "共享开发组"), 合同管理组(2, "合同管理组"), 商务组(3, "商务组"), 技术支持组(4, "技术支持组"), 测试组(5, "测试组"), 质量体系组(6, "质量体系组"),配置管理组(7, "配置管理组"),销售组(8, "销售组"),项目组(9, "项目组");
	private int value;
	private String name;

	private Group(int value, String name) {
		this.value = value;
		this.name = name;
	}

	public static String getInstance(int i) {
		Group[] allStatus = Group.values();
		for (Group ws : allStatus) {
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
