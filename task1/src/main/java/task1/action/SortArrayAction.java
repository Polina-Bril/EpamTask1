package task1.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import task1.entity.CustomArray;
import task1.exception.CustomArrayException;
import task1.validator.DataValidator;

public class SortArrayAction {
	static Logger logger = LogManager.getLogger();

	public int[] bubbleSorting(CustomArray array) throws CustomArrayException {
		logger.info("Entered bubbleSorting function");
		if (DataValidator.isEmpty(array)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] arrayToSort = array.getArray();
		int arrayLength = array.getSize();
		for (int i = 0; i < arrayLength - 1; i++) {
			for (int j = 0; j < arrayLength - 1 - i; j++) {
				if (arrayToSort[j] > arrayToSort[j + 1]) {
					int temp = arrayToSort[j];
					arrayToSort[j] = arrayToSort[j + 1];
					arrayToSort[j + 1] = temp;
				}
			}
		}
		return arrayToSort;
	}

	public int[] shakeSorting(CustomArray array) throws CustomArrayException {
		logger.info("Entered shakeSorting function");
		if (DataValidator.isEmpty(array)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] mutableArray = array.getArray();
		int leftBoarder = 0;
		int rightBoarder = array.getSize();
		while (leftBoarder <= rightBoarder) {
			for (int i = leftBoarder; i < rightBoarder - 1; i++) {
				if (mutableArray[i] > mutableArray[i + 1]) {
					int temp = mutableArray[i];
					mutableArray[i] = mutableArray[i + 1];
					mutableArray[i + 1] = temp;
				}
			}
			rightBoarder--;
			for (int i = rightBoarder - 1; i > leftBoarder; i--) {
				if (mutableArray[i] < mutableArray[i - 1]) {
					int temp = mutableArray[i];
					mutableArray[i] = mutableArray[i - 1];
					mutableArray[i - 1] = temp;
				}
			}
			leftBoarder++;
		}
		return mutableArray;
	}

	public int[] combSorting(CustomArray customArray) throws CustomArrayException {
		logger.info("Entered combSorting function");
		if (DataValidator.isEmpty(customArray)) {
			logger.error("CustomArray for action is empty");
			throw new CustomArrayException("CustomArray for action is empty");
		}
		int[] array = customArray.getArray();
		int arrayLength = customArray.getSize();
		float gapFactor = arrayLength / 1.127f;
		while (gapFactor > 1) {
			int gap = Math.round(gapFactor);
			for (int i = 0; i + gap < arrayLength; i++) {
				if (array[i] > array[i + gap]) {
					int temp = array[i];
					array[i] = array[i + gap];
					array[i + gap] = temp;
				}
			}
			gapFactor /= 1.127f;
		}
		return array;
	}
}