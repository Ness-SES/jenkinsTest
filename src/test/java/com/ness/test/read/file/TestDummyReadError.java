package com.ness.test.read.file;

import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by P3700601 on 03/01/2016.
 */

/*
 * featureBranch commit 1
 */

/*
 * featureBranch commit 2
 */

/*
 * featureBranch commit 3
 */

/*
 * featureBranch commit 4
 */

/*
 * featureBranch commit 5
 */

/*
 * featureBranch commit 6
 */

/*
 * created featureBranch2
 */

public class TestDummyReadError {

	private String line = null;

	private Map<Long, String> mergedData1;
	private Map<Long, String> mergedData2;
	private Map<Long, List<String>> mergedData;
	private StringBuilder values;
	private boolean incrementTheKey;
	private long key = 0;
	private long fileIndex = 0;

	@Test
	public void testRead() throws IOException {
		InputStream stream = TestDummyReadError.class.getResourceAsStream("errorInFile.txt");
		if (null == stream) {
			Assert.fail();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		if (null == reader) {
			Assert.fail();
		}

		List<String> data = getData(reader, -1);

		long start1 = 0;
		long end1 = 0;
		int index = 0;
		while (index < 10 && index < data.size()) {
			end1 += data.get(index).length();
			index++;
		}
		long start2 = end1;
		long end2 = start2;
		while (index < data.size()) {
			end2 += data.get(index).length();
			index++;
		}

		index = 0;

		values = new StringBuilder();
		mergedData1 = new HashMap<Long, String>();
		key = start1;
		incrementTheKey = false;
		fileIndex = 0;
		while (index < 10 && index < data.size()) {
			prepareData(data.get(index), start1, end1, mergedData1);
			index++;
		}

		printData(this.mergedData1);

		values = new StringBuilder();
		mergedData2 = new HashMap<Long, String>();
		key = start2;
		incrementTheKey = false;
		fileIndex = 0;
		while (index < data.size()) {
			prepareData(data.get(index), start2, end2, this.mergedData2);
			index++;
		}

		printData(this.mergedData2);

		stream.close();
	}

	private List<String> getData(BufferedReader reader, int maxNumOfLines) throws IOException {
		List<String> data = new LinkedList<String>();

		int index = 0;
		while ((line = reader.readLine()) != null && (index < maxNumOfLines || 0 > maxNumOfLines)) {
			data.add(line);
			index++;
		}

		return data;
	}

	;

	private void prepareData(String data, long start, long end, Map<Long, String> storedData) {
		if (fileIndex == 0 && start != 0) {
			fileIndex = start;
		}
		fileIndex += data.length();
		boolean containException = data.toLowerCase().contains("exception");
		if (data.startsWith("2") && true == containException) {
			if (true == values.toString().isEmpty()) {
				values = new StringBuilder();
			} else {
				storedData.put(key, values.toString());
				values = new StringBuilder();
			}
			values.append(data);
			values.append("\n");
			key += data.length();
			incrementTheKey = true;
		} else if (data.startsWith("\tat") || true == containException) {
			values.append(data);
			values.append("\n");
			if (true == incrementTheKey) {
				key += data.length();
			}
		} else if (false == containException || true == incrementTheKey) {
			if (false == values.toString().isEmpty()) {
				storedData.put(key, values.toString());
				values.delete(0, values.length());
			}
			key += data.length();
		}
		if (fileIndex == end) {
			storedData.put(key, values.toString());
		}
	}

	private void printData(Map<Long, String> results) {
		for (Map.Entry<Long, String> entry : results.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}

		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

	private void mergeTheData(Map<Long, List<String>> results, Map<Long, String> partial1, Map<Long, String> partial2) {
		if (null == partial1 && null == partial2) {
			return;
		}
		if (null == results) {
			results = new HashMap<Long, List<String>>();
		}
	}
}
