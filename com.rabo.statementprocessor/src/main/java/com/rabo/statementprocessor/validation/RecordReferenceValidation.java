package com.rabo.statementprocessor.validation;

import java.awt.List;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;



public class RecordReferenceValidation {
	
	public static void validationMethod(String[] customerDetails) throws IOException, ClassNotFoundException {
		
	  File  file = new File("CsvFileDuplicatereferences.csv");
		FileOutputStream filestraem = new FileOutputStream(file);
		ObjectOutputStream objectstream = new ObjectOutputStream(filestraem);
		ArrayList<String> validrecords = new ArrayList<String>(Arrays.asList(customerDetails));
		ArrayList<String> failedrecords = new ArrayList<String>();
		Arrays.sort(customerDetails);
		for (int i = 1; i < customerDetails.length; i++) {
			if (customerDetails[i].substring(0, 6).equals(customerDetails[i - 1].substring(0, 6))) {
				validrecords.remove(customerDetails[i]);
				failedrecords.add(customerDetails[i]);

			}
		}
		
		objectstream.writeObject("\nfailed record references");
		System.out.println("failed record references");
		for (String failedRecords : failedrecords) {

			System.out.println(failedRecords);
			objectstream.writeObject("\n"+failedRecords);

		}


		
		String validReferences[] = validrecords.toArray(new String[validrecords.size()]);
		
		EndBalanceValidation.details(validReferences);
		
		
		
	}
}
