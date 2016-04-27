package com.ness.pigunit.junitsuite;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;

class BranchToTestsMap {
	private static final Map<String, Set<Class<?>>> branchToTestClassesMap = new HashMap<String, Set<Class<?>>>();

	void put(String branchName, Class<?>... testClasses) {
		branchToTestClassesMap.put(branchName, filterOutDuplicates(testClasses));
	}

	private static Set<Class<?>> filterOutDuplicates(Class<?>... testClasses) {
		return new HashSet<Class<?>>(Arrays.asList(testClasses));
	}

	Collection<Test> get(String branch) {
		Set<Class<?>> testClasses = branchToTestClassesMap.get(branch);
		if (null != testClasses) {
			return CollectionUtils.collect(testClasses, new Transformer<Class<?>, Test>() {
				@Override
				public Test transform(Class<?> testClass) {
					return new JUnit4TestAdapter(testClass);
				}
			});
		} else {
			return Collections.emptyList();
		}
	}
}
