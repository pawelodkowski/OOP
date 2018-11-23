package bank_ocr;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BankOCR {

	public static void main(String[] args) {
		
		
		String path = "C:\\bank_ocr1_test.txt";
		String defineNumbersPath = "C:\\bank_ocr_dojo_us1";
		
		int[] actualAccountNumber = new int[9];
		String[] numbers = defineNumbers(defineNumbersPath);
		String[] readNumbers = readDigitalAccountNumber(path);

		
		for(int i = 0; i < actualAccountNumber.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (readNumbers[i].equals(numbers[j])) {
					actualAccountNumber[i] = j;
				}
			}
		}
		
		

		
		for(int n:actualAccountNumber) {
			System.out.print(n);
		}
		System.out.println("\n" + "Checksum validation: "+ checkSum(actualAccountNumber));

		
	}
	
	/*
	 * Method works only if account number is on the top of the loaded file...
	 * and sadly only for 1 account number...
	 */
	
	public static String[] readDigitalAccountNumber (String path) {
	
		//String path = "C:\\bank_ocr_dojo_us1";
		
		String[] readNumbers = new String[9];
        
		try {
			
			String line = Files.readAllLines(Paths.get(path)).get(0);
			
            
            	for (int j = 0, k = 0; j < line.length() && k < readNumbers.length; j+=3, k++){
            		
            		readNumbers[k] = "";
            		
	            		for (int i = 0; i < 4; i++) {
	            			
	            			line = Files.readAllLines(Paths.get(path)).get(i);
	            			readNumbers[k] += line.toString().substring(j, j+3)+"\n";
            		
	            		}
            	}
            	
            	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return readNumbers;
	}

	public static String[] defineNumbers (String path) {
		
		String[] number = new String[10];
		
		try {
			
			int n = 0;
            String line = Files.readAllLines(Paths.get(path)).get(n);
 
            for (int j = 0; j < number.length; j++) {
            	
            	number[j] = ""; //String must be initialized, otherwise it will be pointed to null
            	
                for (int i = 0; i < 4; i++) {
                	
                	number[j] += line.subSequence(0, 3).toString()+"\n";
                	line = Files.readAllLines(Paths.get(path)).get(++n);
             
                }
            }
           
        } catch (FileNotFoundException e) {
        	
            System.out.println("File not found!");
            System.exit(0);
            
        } catch (IOException e) {
        	
        	System.out.println("File not found!");
        	System.exit(0);
        	
        }
		
		return number;
	}

	public static boolean checkSum (int [] acNumber) {
		
		int checkSum = 0;
		
		for (int i = 0, j = 9; i < acNumber.length && j > 0; i++, j--) {
			checkSum += acNumber[i]*j;			
		}
		
		if(checkSum%11 == 0) 
			return true;
		
		return false;
	}
}


