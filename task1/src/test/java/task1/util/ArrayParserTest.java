package task1.util;

import static org.junit.Assert.assertEquals;

import org.testng.annotations.Test;

public class ArrayParserTest {
	ArrayParser parser = new ArrayParser();

	@Test
	public void testFromStringToIntArray() {
		String testStringData = "1 3 5 3 6 -2 -43 1 2";
		int[] actual = parser.fromStringToArray(testStringData);
		int[] expected = { 1, 3, 5, 3, 6, -2, -43, 1, 2 };
		assertEquals(actual, expected);
	}

	@Test
	public void testFromStringToIntArrayWithStream() {
		String testStringData = "1 3 5 3 6 -2 -43 1 2";
		int[] actual = parser.fromStringToArrayWithStream(testStringData);
		int[] expected = { 1, 3, 5, 3, 6, -2, -43, 1, 2 };
		assertEquals(actual, expected);
	}
}
