package task1.action;

import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import task1.entity.CustomArray;
import task1.exception.CustomArrayException;
import task1.validator.DataValidator;

public class ArrayCalculationActionWithStream {
	static Logger logger = LogManager.getLogger();

	public int findPositiveElements(CustomArray array) throws CustomArrayException {
		logger.info("Entered findPositiveElements function");
		if (DataValidator.isEmpty(array)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] initialArray = array.getArray();
		return (int) IntStream.of(initialArray).filter(x -> x >= 0).count();
	}

	public int findNegativeElements(CustomArray array) throws CustomArrayException {
		logger.info("Entered findNegativeElements function");
		if (DataValidator.isEmpty(array)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] initialArray = array.getArray();
		return (int) IntStream.of(initialArray).filter(x -> x < 0).count();
	}

	public int[] oddElementsMultiplyByTwo(CustomArray customArray) throws CustomArrayException {
		logger.info("Entered oddElementsMultiplyByTwo function");
		if (DataValidator.isEmpty(customArray)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] array = customArray.getArray();
		IntStream stream = IntStream.of(array);

		int[] arr = stream.map(intValue -> {
			if (intValue % 2 != 0) {
				return intValue * 2;
			} else {
				return intValue;
			}
		}).toArray();
		customArray.setArray(arr);
		return arr;
	}
}
