package task1.action;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import task1.entity.CustomArray;
import task1.exception.CustomArrayException;

public class ArrayCalculationActionTest {
	static Logger logger = LogManager.getLogger();

	ArrayCalculationAction arrayCalculationAction;
	CustomArray customArray;

	@BeforeClass
	public void setUp() {
		customArray = new CustomArray();
		arrayCalculationAction = new ArrayCalculationAction();
	}

	@Test(dataProvider = "arrays_OddElementsMultiplyByTwo")
	public void testCustomArrayActionIntStreamOddElementsMultiplyByTwo(int[] array, int[] expectedValue)
			throws CustomArrayException {
		customArray.setArray(array);
		int[] actual = arrayCalculationAction.oddElementsMultiplyByTwo(customArray);
		boolean result = Arrays.equals(actual, expectedValue);
		assertTrue(result);
	}

	@Test(dataProvider = "arrays_numberPositiveElements")
	public void testCustomArrayActionNumberPositiveElements(int[] array, int expectedValue)
			throws CustomArrayException {
		customArray.setArray(array);
		int actualValue = arrayCalculationAction.findPositiveElements(customArray);
		assertEquals(actualValue, expectedValue);
	}

	@Test(dataProvider = "arrays_numberNegativeElements")
	public void testCustomArrayActionNumberNegativeElements(int[] array, int expectedValue)
			throws CustomArrayException {
		customArray.setArray(array);
		int actualValue = arrayCalculationAction.findNegativeElements(customArray);
		assertEquals(actualValue, expectedValue);
	}

	@DataProvider(name = "arrays_OddElementsMultiplyByTwo")
	public Object[] createDataOddElementsMultiplyByTwo() {
		return new Object[][] { { new int[] { 1, 2, 5, -1 }, new int[] { 2, 2, 10, -2 } },
				{ new int[] { -9, 8, 7, 20 }, new int[] { -18, 8, 14, 20 } } };
	}

	@DataProvider(name = "arrays_numberPositiveElements")
	public Object[] createDataNumberPositiveElements() {
		return new Object[][] { { new int[] { 1, 2, 3, -1 }, 3 }, { new int[] { 1, 2, -20, 5, 10 }, 4 } };
	}

	@DataProvider(name = "arrays_numberNegativeElements")
	public Object[] createDataNumberNegativeElements() {
		return new Object[][] { { new int[] { 1, 2, 3, -1 }, 1 }, { new int[] { 1, 2, -20, 5, 10 }, 1 } };
	}

	@AfterClass
	public void tierDown() {
		arrayCalculationAction = null;
		customArray = null;
	}
}