package task1.action;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import task1.entity.CustomArray;
import task1.exception.CustomArrayException;

public class ArithmeticArrayActionTest {
	static Logger logger = LogManager.getLogger();

	ArithmeticArrayAction arithmeticAction;
	CustomArray customArray;

	@BeforeClass
	public void setUp() {
		customArray = new CustomArray();
		arithmeticAction = new ArithmeticArrayAction();
	}

	@Test(dataProvider = "arrays_min")
	public void testFindMin(int[] array, int expected) throws CustomArrayException {
		customArray.setArray(array);
		int actual = arithmeticAction.findMinElement(customArray);
		assertEquals(actual, expected);
	}

	@Test(dataProvider = "arrays_max")
	public void testFindMax(int[] array, int expected) throws CustomArrayException {
		customArray.setArray(array);
		int actual = arithmeticAction.findMaxElement(customArray);
		assertEquals(actual, expected);
	}

	@Test(dataProvider = "arrays_sum")
	public void testFindSum(int[] array, int expectedValue) throws CustomArrayException {
		customArray.setArray(array);
		int actualValue = arithmeticAction.findSum(customArray);
		assertEquals(actualValue, expectedValue);
	}

	@Test(dataProvider = "arrays_averageValue")
	public void testFindAverage(int[] array, double expected) throws CustomArrayException {
		customArray.setArray(array);
		double actual = arithmeticAction.findAverage(customArray);
		assertEquals(actual, expected, 0.001);
	}

	@DataProvider(name = "arrays_min")
	public Object[] createDataMin() {
		return new Object[][] { { new int[] { 1, 2, Integer.MIN_VALUE, -1 }, Integer.MIN_VALUE },
				{ new int[] { 1, 2, -20, 5, 10 }, -20 } };
	}

	@DataProvider(name = "arrays_max")
	public Object[] createDataMax() {
		return new Object[][] { { new int[] { 1, 2, Integer.MAX_VALUE, -1 }, Integer.MAX_VALUE },
				{ new int[] { 1, 2, -20, 5, 10 }, 10 } };
	}

	@DataProvider(name = "arrays_averageValue")
	public Object[] createDataAverageValue() {
		return new Object[][] { { new int[] { 1, 3, -3 }, 0.333 }, { new int[] { 1, 2, -20, 5, 10 }, -0.4 } };
	}

	@DataProvider(name = "arrays_sum")
	public Object[] createDataSum() {
		return new Object[][] { { new int[] { 1, 2, 3, -1 }, 5 }, { new int[] { 1, 2, -20, 5, 10 }, -2 } };
	}

	@AfterClass
	public void tierDown() {
		customArray = null;
		arithmeticAction = null;
	}
}
