package com.hsmt.util;

import java.util.Random;

public class RandomUtil {
	/* ���������ķ��� */
	public String getFixLenthString(int strLength) {
		Random rm = new Random();
		/* �������� */
		double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
		/* ����õĻ�������ת��Ϊ�ַ��� */
		String fixLenthString = String.valueOf(pross);
		/* ���ع̶��ĳ��ȵ������ */
		return fixLenthString.substring(1, strLength + 1);
	}
}
