package com.hsmt.util;

import java.util.Random;

/**
 * 获取随机数
 */
public class RandomUtil {
	public String getFixLenthString(int strLength) {
		Random rm = new Random();
		double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
		String fixLenthString = String.valueOf(pross);
		return fixLenthString.substring(1, strLength + 1);
	}
}
