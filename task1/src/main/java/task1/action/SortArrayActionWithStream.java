package task1.action;

import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import task1.entity.CustomArray;
import task1.exception.CustomArrayException;
import task1.validator.DataValidator;

public class SortArrayActionWithStream {
	static Logger logger = LogManager.getLogger();

	public int[] sortingWithStream(CustomArray customArray) throws CustomArrayException {
		logger.info("Entered sortingWithStream function");
		if (DataValidator.isEmpty(customArray)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] array = customArray.getArray();
		return IntStream.of(array).sorted().toArray();
	}
}