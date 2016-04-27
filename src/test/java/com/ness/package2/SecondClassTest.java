package com.ness.package2;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class SecondClassTest {
	@Test
	public void test() {
		System.out.println("*** " + this.getClass().getName());
	}
}
