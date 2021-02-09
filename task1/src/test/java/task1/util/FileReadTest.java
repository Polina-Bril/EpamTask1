package task1.util;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import task1.exception.CustomArrayException;

public class FileReadTest {
	static final String TEST_FILE = "data\\arrays.txt";
	static final String TEST_FILE_ERROR = "data\\no_such_file.txt";

	FileRead reader;

	@BeforeClass
	public void setUp() {
		reader = new FileRead();
	}

	@Test
	public void testRead() throws CustomArrayException {
		String actual;
		actual = reader.read(TEST_FILE);
		String expected = "-1 5 -3 2 600 -90"
				+ "7 2z 32 43 56 1 7 8 9"
				+ "-63 -21 -43 -54 -76 -1"
				+ "-3 2 1 0 1 -8b -7 -6 -5";
		assertEquals(actual, expected);
	}

	@Test(expectedExceptionsMessageRegExp = "File not found")
	public void testReadExceptionMessage() {
		try {
			reader.read(TEST_FILE_ERROR);
			fail("Test for read " + TEST_FILE_ERROR + " should have thrown a CustomArrayException");
		} catch (CustomArrayException e) {
			assertEquals(e.getMessage(), "CustomArrayException - file not found: " + TEST_FILE_ERROR);
		}
	}

	@AfterClass
	public void tierDown() {
		reader = null;
	}
}