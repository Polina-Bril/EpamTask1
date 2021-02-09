package task1.util;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import task1.exception.CustomArrayException;
import task1.validator.DataValidator;

public class FileRead {
	static Logger logger = LogManager.getLogger();

	public String read(String fileName) throws CustomArrayException {
		if (fileName.isEmpty()) {
			throw new CustomArrayException("Filename is Empty " + fileName);
		}
		String data = null;
		Scanner scanner = null;
		File file = new File(FileRead.class.getClassLoader().getResource(fileName).getPath());
		logger.info(file);
		try {
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				data = scanner.nextLine();
				logger.info("Reading line " + data);
				if (DataValidator.isStringValid(data)) {
					break;
				}
			}
		} catch (IOException e) {
			logger.error("File not found: " + fileName);
			throw new CustomArrayException("File not found");
		} finally {
			if (scanner != null) {
				scanner.close();
			}
		}

		return data;
	}
}