package com.ness.package2;

import org.junit.Test;

public class SecondClassTest {
	@Test
	public void test() {
		System.out.println("*** " + this.getClass().getName());
	}
}
