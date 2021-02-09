package task1.entity;

import java.util.Arrays;

import task1.exception.CustomArrayException;

public class CustomArray {
	private int[] array;

	public CustomArray() {
	}

	public CustomArray(int[] a) {
		super();
		this.array = a;
	}

	public CustomArray(int n) throws CustomArrayException {
		if (n < 1) {
			throw new CustomArrayException();
		}
		array = new int[n];
	}

	public int getSize() {
		return array.length;
	}

	public int getElement(int i) throws CustomArrayException {
		if (checkRange(i)) {
			return array[i];
		} else {
			throw new CustomArrayException();
		}
	}

	public int[] getArray() {
		return array;
	}

	public void setArray(int[] a) {
		this.array = a;
	}

	public void setElement(int i, int value) throws CustomArrayException {
		if (checkRange(i)) {
			array[i] = value;
		} else {
			throw new CustomArrayException();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(array);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomArray other = (CustomArray) obj;
		if (!Arrays.equals(array, other.array))
			return false;
		return true;
	}

	@Override
	public String toString() {
		final String BLANK = " ";
		StringBuilder s = new StringBuilder("Array with length: " + array.length + "\n");
		for (int value : array) {
			s.append(value).append(BLANK);
		}
		return s.toString();
	}

	private boolean checkRange(int i) {
		return (i >= 0 && i < array.length);
	}
}
