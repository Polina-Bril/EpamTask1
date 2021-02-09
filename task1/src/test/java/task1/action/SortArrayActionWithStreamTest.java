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

public class SortArrayActionWithStreamTest {
	static Logger logger = LogManager.getLogger();

	SortArrayActionWithStream sortArrayActionWithStream;
	CustomArray customArray;

	@BeforeClass
	public void setUp() {
		customArray = new CustomArray();
		sortArrayActionWithStream = new SortArrayActionWithStream();
	}

	@Test(dataProvider = "arrays_sortStream")
	public void testCustomArrayActionSortStream(int[] array, int[] expectedValue) throws CustomArrayException {
		logger.info("StreamSorting");
		customArray.setArray(array);
		int[] actual = sortArrayActionWithStream.sortingWithStream(customArray);
		boolean result = Arrays.equals(actual, expectedValue);
		assertTrue(result);
	}

	@DataProvider(name = "arrays_sortStream")
	public Object[] createDataSortStream() {
		return new Object[][] { { new int[] { 1, 2, 5, -1 }, new int[] { -1, 1, 2, 5 } },
				{ new int[] { -9, 8, 7, 20 }, new int[] { -9, 7, 8, 20 } } };
	}

	@AfterClass
	public void tierDown() {
		sortArrayActionWithStream = null;
		customArray = null;
	}
}
