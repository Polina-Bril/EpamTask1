package task1.validator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import task1.entity.CustomArray;

public class DataValidatorTest {
	@Test
	public void testIsStringValid() {
		String testString = "1 3 5 3 6 -2 -43 1 2";
		assertTrue(DataValidator.isStringValid(testString));
	}

	@Test
	public void testIsStringValidWithStream() {
		String testString = "1 3 5 3 6 -2 -43 1 2";
		assertTrue(DataValidator.isStringValidWithStream(testString));
	}

	@Test
	public void testIsEmpty() {
		int[] testArray = { 1, 3, 5, 3 };
		CustomArray array = new CustomArray(testArray);
		assertFalse(DataValidator.isEmpty(array));
	}
}