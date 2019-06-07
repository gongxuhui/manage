package com.hsmt.util;

public enum Group {
	����������(0, "����������"), ��������(1, "��������"), ��ͬ������(2, "��ͬ������"), ������(3, "������"), ����֧����(4, "����֧����"), ������(5, "������"), ������ϵ��(6,
			"������ϵ��"),���ù�����(7, "���ù�����"),������(8, "������"),��Ŀ��(9, "��Ŀ��");
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
		throw new IllegalArgumentException("statusֵ�Ƿ���û�з��ϵ�ö�ٶ���");
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}
}
