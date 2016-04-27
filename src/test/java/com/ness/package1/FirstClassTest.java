package com.ness.package1;

import org.junit.Test;

public class FirstClassTest {
	@Test
	public void test() {
		System.out.println("*** " + this.getClass().getName());
	}
}
