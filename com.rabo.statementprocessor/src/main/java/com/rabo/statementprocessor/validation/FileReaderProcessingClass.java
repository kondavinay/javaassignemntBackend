package com.rabo.statementprocessor.validation;

import java.io.IOException;

import com.rabo.statementprocessor.pojo.*;
import com.rabo.statementprocessor.validation.RecordReferenceValidation;

public class FileReaderProcessingClass {

	public static void fileReader(CsvANDXmlPojo[] filearray) throws ClassNotFoundException, IOException {

		String[] cusDetails= new String[filearray.length];

		for (int i = 0; i < filearray.length; i++) {
			cusDetails[i] = filearray[i].getReference() + "," + filearray[i].getAccountNumber() + ","
					+ filearray[i].getDescription() + "," + filearray[i].getStartBal() + ","
					+ filearray[i].getMutation() + "," + filearray[i].getEndBal();

		}
		RecordReferenceValidation.validationMethod(cusDetails);

	}
}
