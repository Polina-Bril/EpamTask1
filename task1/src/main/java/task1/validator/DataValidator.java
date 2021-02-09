package task1.validator;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import task1.entity.CustomArray;

public class DataValidator {
	static Logger logger = LogManager.getLogger();
	static final String DELIMETR = " ";

	public static boolean isStringValid(String data) {
		boolean response = true;
		String[] dataArray = data.split(DELIMETR);
		try {
			for (String element : dataArray) {
				Integer.parseInt(element);
			}
		} catch (NumberFormatException e) {
			logger.info("String is not valid " + data);
			response = false;
		}
		return response;
	}

	public static boolean isStringValidWithStream(String data) {
		boolean response = true;
		String[] dataArray = data.split(DELIMETR);
		try {
			Arrays.stream(dataArray).mapToInt(Integer::parseInt).toArray();
		} catch (NumberFormatException e) {
			logger.info("String is not valid " + data);
			response = false;
		}
		return response;
	}

	public static boolean isEmpty(CustomArray array) {
		return array == null || array.getArray() == null || array.getSize() == 0;
	}
}
