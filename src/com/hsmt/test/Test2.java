package com.hsmt.test;

import org.junit.Test;

import com.hsmt.util.HyUtil;

public class Test2 {
	@Test
	public void pNode() {
		HyUtil hy = new HyUtil();
		hy.cn2Spell("�����");
		// System.out.println(hy.cn2Spell("�����"));
		System.out.println(hy.cn2FirstSpell("�����"));
	}

}
