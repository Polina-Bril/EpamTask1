package task1.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import task1.entity.CustomArray;
import task1.exception.CustomArrayException;
import task1.validator.DataValidator;

public class ArithmeticArrayAction {
	static Logger logger = LogManager.getLogger();

	public int findMaxElement(CustomArray array) throws CustomArrayException {
		logger.info("Entered findMaxElement function");
		if (DataValidator.isEmpty(array)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int max = array.getElement(0);
		for (int i = 0; i < array.getSize(); i++) {
			if (array.getElement(i) > max)
				max = array.getElement(i);
		}
		return max;
	}

	public int findMinElement(CustomArray array) throws CustomArrayException {
		logger.info("Entered findMinElement function");
		if (DataValidator.isEmpty(array)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}

		int min = array.getElement(0);
		for (int i = 0; i < array.getSize(); i++) {
			if (array.getElement(i) < min)
				min = array.getElement(i);
		}
		return min;
	}

	public int findSum(CustomArray array) throws CustomArrayException {
		logger.info("Entered findSum function");
		if (DataValidator.isEmpty(array)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int sum = 0;
		for (int i = 0; i < array.getSize(); i++) {
			sum += array.getElement(i);
		}
		return sum;
	}

	public double findAverage(CustomArray array) throws CustomArrayException {
		logger.info("Entered findAverage function");
		int arraySum = findSum(array);
		double average = (double) arraySum / array.getSize();
		return average;
	}
}
