package task1.action;

import static org.testng.Assert.assertEquals;

import java.util.OptionalDouble;
import java.util.OptionalInt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import task1.entity.CustomArray;
import task1.exception.CustomArrayException;

public class ArithmeticArrayActionWithStreamTest {
	static Logger logger = LogManager.getLogger();

	ArithmeticArrayActionWithStream arithmeticActionWithStream;
	CustomArray customArray;

	@BeforeClass
	public void setUp() {
		customArray = new CustomArray();
		arithmeticActionWithStream = new ArithmeticArrayActionWithStream();
	}

	@Test(dataProvider = "arrays_min")
	public void testCustomArrayActionIntStreamMinElement(int[] array, OptionalInt expectedValue)
			throws CustomArrayException {
		customArray.setArray(array);
		OptionalInt actualValue = arithmeticActionWithStream.findMinElement(customArray);
		assertEquals(actualValue, expectedValue);
	}

	@Test(dataProvider = "arrays_max")
	public void testCustomArrayActionIntStreamMaxElement(int[] array, OptionalInt expectedValue)
			throws CustomArrayException {
		customArray.setArray(array);
		OptionalInt actualValue = arithmeticActionWithStream.findMaxElement(customArray);
		assertEquals(actualValue, expectedValue);
	}

	@Test(dataProvider = "arrays_averageValue")
	public void testCustomArrayActionIntStreamAverageValue(int[] array, OptionalDouble expectedValue)
			throws CustomArrayException {
		customArray.setArray(array);
		OptionalDouble actualValue = arithmeticActionWithStream.findAverage(customArray);
		assertEquals(actualValue, expectedValue);
	}

	@Test(dataProvider = "arrays_sum")
	public void testCustomArrayActionSum(int[] array, int expectedValue) throws CustomArrayException {
		customArray.setArray(array);
		int actualValue = arithmeticActionWithStream.findSum(customArray);
		assertEquals(actualValue, expectedValue);
	}

	@DataProvider(name = "arrays_min")
	public Object[] createDataMin() {
		return new Object[][] { { new int[] { 1, -100, 3, 4, 5 }, OptionalInt.of(-100) },
				{ new int[] { 1, 2, -20, 5, 10 }, OptionalInt.of(-20) } };
	}

	@DataProvider(name = "arrays_max")
	public Object[] createDataMax() {
		return new Object[][] { { new int[] { 1, -100, 3, 4, 999 }, OptionalInt.of(999) },
				{ new int[] { 1, 2, -20, 5, 10 }, OptionalInt.of(10) } };
	}

	@DataProvider(name = "arrays_averageValue")
	public Object[] createDataAverageValue() {
		return new Object[][] { { new int[] {}, OptionalDouble.empty() },
				{ new int[] { 1, 2, -20, 5, 10 }, OptionalDouble.of(-0.4) } };
	}

	@DataProvider(name = "arrays_sum")
	public Object[] createDataSum() {
		return new Object[][] { { new int[] { 1, 2, 3, -1 }, 5 }, { new int[] { 1, 2, -20, 5, 10 }, -2 } };
	}

	@AfterClass
	public void tierDown() {
		customArray = null;
		arithmeticActionWithStream = null;

	}
}
