package com.rabo.statementprocessor.validation;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigDecimal;



public class ValidationClass {
	
	public static void validationMethod(String[] customerDetails) throws IOException, ClassNotFoundException {
		
	   //File file = new File("csvfileoutput.csv");
		//FileOutputStream filestraem = new FileOutputStream(file);
		//ObjectOutputStream objectstream = new ObjectOutputStream(filestraem);
		ArrayList<String> validrecords = new ArrayList<String>(Arrays.asList(customerDetails));
		ArrayList<String> failedrecords = new ArrayList<String>();
		Arrays.sort(customerDetails);
		for (int i = 1; i < customerDetails.length; i++) {
			if (customerDetails[i].substring(0, 6).equals(customerDetails[i - 1].substring(0, 6))) {
				validrecords.remove(customerDetails[i]);
				failedrecords.add(customerDetails[i]);

			}
		}
		
		//objectstream.writeObject("\nfailed record references");
		System.out.println("failed record references");
		for (String failedRecords : failedrecords) {

			System.out.println(failedRecords);
			//objectstream.writeObject("\n"+failedRecords);

		}


		//ArrayList<String> failedvalidations = new ArrayList<String>();
		String value2[] = validrecords.toArray(new String[validrecords.size()]);
		
		EndBalanceValidation.details(value2);
		
		//System.out.println("\nsuccess EndBalance validation records");
		//objectstream.writeChars("\n Endbalance matched records");
		
		/*for (String mack : value2) {
			String[] value = mack.split(",");
			
			BigDecimal startbal = new BigDecimal(value[3]);
			BigDecimal mutationbal= new BigDecimal(value[4]);
			BigDecimal  balancetovalidate= startbal.add(mutationbal);
			BigDecimal endbal = new BigDecimal(value[5]);

			if (balancetovalidate.equals(endbal)) {

				System.out.println("\nRecord Transaction Reference : " + value[0]);

				System.out.println("Description: " + value[2]);
				//objectstream.writeChars("\nRecord \nTransaction Reference : " +
						 //value[0]+"\n"+"Description: " + value[2]);

			} else if (balancetovalidate != endbal) {

				failedvalidations.add("\nRecord\nTransaction Reference : " + value[0] + "\nDescription  : " + value[2]);

			}

		}
		//objectstream.writeObject("\nEndBalancefailed records");
		System.out.println("\nfailed  EndBalance validation records");
		for (String endBalFailedRecords : failedvalidations) {

			System.out.println(endBalFailedRecords);
			//objectstream.writeObject("\n"+endBalFailedRecords);
		}
		//objectstream.close();
		//filestraem.close();*/
	}
}
