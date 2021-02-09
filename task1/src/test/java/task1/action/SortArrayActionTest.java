package task1.action;

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

public class SortArrayActionTest {
	static Logger logger = LogManager.getLogger();

	SortArrayAction sortArrayAction;
	CustomArray customArray;

	@BeforeClass
	public void setUp() {
		customArray = new CustomArray();
		sortArrayAction = new SortArrayAction();
	}

	@Test(dataProvider = "arrays_bubbleSort")
	public void testCustomArrayActionBubbleSort(int[] array, int[] expectedValue) throws CustomArrayException {
		logger.info("BubleSorting");
		customArray.setArray(array);
		int[] actual = sortArrayAction.bubbleSorting(customArray);
		boolean result = Arrays.equals(actual, expectedValue);
		assertTrue(result);
	}

	@Test(dataProvider = "arrays_shakeSort")
	public void testCustomArrayActionShakeSort(int[] array, int[] expectedValue) throws CustomArrayException {
		logger.info("ShakeSorting");
		customArray.setArray(array);
		int[] actual = sortArrayAction.shakeSorting(customArray);
		boolean result = Arrays.equals(actual, expectedValue);
		assertTrue(result);
	}

	@Test(dataProvider = "arrays_mergeSort")
	public void testCustomArrayActioncombSort(int[] array, int[] expectedValue) throws CustomArrayException {
		logger.info("CombSorting");
		customArray.setArray(array);
		int[] actual = sortArrayAction.combSorting(customArray);
		boolean result = Arrays.equals(actual, expectedValue);
		assertTrue(result);
	}

	@DataProvider(name = "arrays_bubbleSort")
	public Object[] createDataBubbleSort() {
		return new Object[][] { { new int[] { 1, 2, 3, -1 }, new int[] { -1, 1, 2, 3 } },
				{ new int[] { 9, 2, -44, -100 }, new int[] { -100, -44, 2, 9 } },
				{ new int[] { -300, -500, 900, 0 }, new int[] { -500, -300, 0, 900 } },
				{ new int[] { -4, -3, 9, 7 }, new int[] { -4, -3, 7, 9 } },
				{ new int[] { 7, 4, 2, -5 }, new int[] { -5, 2, 4, 7 } } };
	}

	@DataProvider(name = "arrays_shakeSort")
	public Object[] createDataQuickSort() {
		return new Object[][] { { new int[] { 1, 2, 3, -1 }, new int[] { -1, 1, 2, 3 } },
				{ new int[] { 9, 2, -44, -100 }, new int[] { -100, -44, 2, 9 } },
				{ new int[] { -300, -500, 900, 0 }, new int[] { -500, -300, 0, 900 } },
				{ new int[] { -4, -3, 9, 7 }, new int[] { -4, -3, 7, 9 } },
				{ new int[] { 7, 4, 2, -5 }, new int[] { -5, 2, 4, 7 } } };
	}

	@DataProvider(name = "arrays_mergeSort")
	public Object[] createDataMergeSort() {
		return new Object[][] { { new int[] { 1, 2, 3, -1 }, new int[] { -1, 1, 2, 3 } },
				{ new int[] { 9, 2, -44, -100 }, new int[] { -100, -44, 2, 9 } },
				{ new int[] { -300, -500, 900, 0 }, new int[] { -500, -300, 0, 900 } },
				{ new int[] { -4, -3, 9, 7 }, new int[] { -4, -3, 7, 9 } },
				{ new int[] { 7, 4, 2, -5 }, new int[] { -5, 2, 4, 7 } } };
	}

	@AfterClass
	public void tierDown() {
		sortArrayAction = null;
		customArray = null;
	}
}
