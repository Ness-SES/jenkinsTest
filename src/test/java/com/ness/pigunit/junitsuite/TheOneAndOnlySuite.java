package com.ness.pigunit.junitsuite;

import org.junit.runner.RunWith;
import org.junit.runners.AllTests;

import junit.framework.Test;
import junit.framework.TestSuite;

@RunWith(AllTests.class)
public final class TheOneAndOnlySuite {
	private static final String BRANCH_NAME = System.getProperty("branchName");

	private static final BranchToTestsMap branchToTestsMap = new BranchToTestsMap();

	static {
		branchToTestsMap.put("origin/featureBranch_0", com.ness.package1.FirstClassTest.class);
		branchToTestsMap.put("origin/featureBranch_2", com.ness.package2.SecondClassTest.class,
				com.ness.package2.SecondClassTest.class);
	};

	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		for (Test test : branchToTestsMap.get(BRANCH_NAME)) {
			suite.addTest(test);
		}
		return suite;
	}
}
