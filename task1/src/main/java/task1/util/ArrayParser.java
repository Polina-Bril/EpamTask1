package task1.util;

import java.util.Arrays;

public class ArrayParser {

	static final String DELIMETR = " ";

	public int[] fromStringToArray(String data) {
		String[] array = data.split(DELIMETR);
		int size = array.length;
		int[] result = new int[size];
		for (int i = 0; i < size; i++) {
			result[i] = Integer.parseInt(array[i]);
		}
		return result;
	}

	public int[] fromStringToArrayWithStream(String data) {
		String[] array = data.split(DELIMETR);
		return Arrays.stream(array).mapToInt(Integer::parseInt).toArray();
	}
}