package com.hsmt.test;

import org.junit.Test;

import com.hsmt.util.RandomUtil;

public class Test5 {
	@Test
	public void gg() {
		RandomUtil ru = new RandomUtil();
		for (int i = 0; i <= 10; i++) {
			System.out.println(ru.getFixLenthString(6));
			int num = Integer.parseInt(ru.getFixLenthString(6));
			System.out.println(num);
		}

	}
}
