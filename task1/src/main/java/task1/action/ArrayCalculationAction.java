package task1.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import task1.entity.CustomArray;
import task1.exception.CustomArrayException;
import task1.validator.DataValidator;

public class ArrayCalculationAction {
	static Logger logger = LogManager.getLogger();

	public int findPositiveElements(CustomArray array) throws CustomArrayException {
		logger.info("Entered findPositiveElements function");
		if (DataValidator.isEmpty(array)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int count = 0;
		for (int i = 0; i < array.getSize(); i++) {
			if (array.getElement(i) > 0)
				count++;
		}
		return count;
	}

	public int findNegativeElements(CustomArray array) throws CustomArrayException {
		logger.info("Entered findNegativeElements function");
		if (DataValidator.isEmpty(array)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int count = 0;
		for (int i = 0; i < array.getSize(); i++) {
			if (array.getElement(i) < 0)
				count++;
		}
		return count;
	}

	public int[] oddElementsMultiplyByTwo(CustomArray customArray) throws CustomArrayException {
		logger.info("Entered changeElements function");
		if (DataValidator.isEmpty(customArray)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] array = customArray.getArray();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 != 0) {
				array[i] = array[i] * 2;
			}
		}
		return array;
	}
}
