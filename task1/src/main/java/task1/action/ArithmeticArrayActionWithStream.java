package task1.action;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import task1.entity.CustomArray;
import task1.exception.CustomArrayException;
import task1.validator.DataValidator;

public class ArithmeticArrayActionWithStream {
	static Logger logger = LogManager.getLogger();

	public OptionalInt findMaxElement(CustomArray customArray) throws CustomArrayException {
		logger.info("Entered findMaxElementWithStream function");
		if (DataValidator.isEmpty(customArray)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] array = customArray.getArray();
		IntStream stream = IntStream.of(array);
		return stream.max();
	}

	public OptionalInt findMinElement(CustomArray customArray) throws CustomArrayException {
		logger.info("Entered findMinElementWithStream function");
		if (DataValidator.isEmpty(customArray)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] array = customArray.getArray();
		IntStream stream = IntStream.of(array);
		return stream.min();
	}

	public int findSum(CustomArray customArray) throws CustomArrayException {
		logger.info("Entered findSumWithStream function");
		if (DataValidator.isEmpty(customArray)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] initialArray = customArray.getArray();
		return IntStream.of(initialArray).sum();
	}

	public OptionalDouble findAverage(CustomArray customArray) throws CustomArrayException {
		logger.info("Entered findAverageWithStream function");
		if (DataValidator.isEmpty(customArray)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] array = customArray.getArray();
		return IntStream.of(array).average();
	}
}