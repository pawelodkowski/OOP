package bank_ocr;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class BankOCR {

	public static void main(String[] args) {
		
		
		String path = "C:\\bank_ocr_dojo_us3";
		String defineNumbersPath = "C:\\bank_ocr_dojo_us1";
		
		
		String[] numbers = defineNumbers(defineNumbersPath);
		String[][] readNumbers = readDigitalAccountNumbers(path);
		int[][] actualAccountNumber = new int[readNumbers.length][9];
		
		for (int r = 0; r < readNumbers.length; r++) {
			for(int i = 0; i < 9; i++) {
				for (int j = 0; j < numbers.length; j++) {
					if (readNumbers[r][i].equals(numbers[j])) {
						actualAccountNumber[r][i] = j;
					}
				}
			}
		}	
		
		for (int r = 0; r < actualAccountNumber.length; r++) {
			for (int i = 0; i < 9; i++) {
				System.out.print(actualAccountNumber[r][i]);
			}
			System.out.print(" "+checkSum(actualAccountNumber)[r]);
			System.out.println();
		}
		
		
		
	}
	

	
	public static String[][] readDigitalAccountNumbers(String path) {
		/*
		 * This method works for more that 1 account number in read file
		 *
		 */
		
		long numberOfLines = 0;
		
		try {
			numberOfLines = Files.lines(Paths.get(path)).count();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		int numberOfAccNumbers = (int) numberOfLines/4;
		
		String [][] readNumbers = new String[numberOfAccNumbers][9];
		
			for (int j = 0; j < numberOfAccNumbers; j++) {
				for (int i = 0; i < 9; i++) {
					readNumbers[j][i] = "";
				}
			}

       
		try {
			String line = Files.readAllLines(Paths.get(path)).get(0);
			
			int currentLineRead = 0;
			for (int l = 0, r = 0; l < numberOfLines - 1 && r < numberOfLines; l+=4, r++) {
				
            	for (int j = 0, k = 0; j < line.length() && k < 9; j+=3, k++){
            		
	            		for (int i = 0; i < 4 ; i++) {
	            			
	            			line = Files.readAllLines(Paths.get(path)).get(currentLineRead+i);
	            			readNumbers[r][k] += line.toString().substring(j, j+3)+"\n";

	            		}
	            		
	            	}
            	
            	currentLineRead+=4;
			}
					

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return readNumbers;

	}
	
	public static String[] readDigitalAccountNumber (String path) {
	
		
		/*
		 * Method works only if account number is on the top of the loaded file...
		 * and sadly only for 1 account number...
		 */
		
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

	public static boolean[] checkSum (int [][] acNumber) {
		
		int[] checkSum = new int[acNumber.length];
		boolean[] sum = new boolean[acNumber.length];
		
		for (int r = 0; r < acNumber.length; r++) {
			for (int i = 0, j = 9; i < 9 && j > 0; i++, j--) {
				
				checkSum[r] += acNumber[r][i]*j;	
				//System.out.print(acNumber[r][i]);
			}
			//System.out.println();
		}

		for (int r = 0; r < acNumber.length; r++) {
				if (checkSum[r]%11==0) {
					sum[r] = true;
				}
		}
		return sum;
		
	}
}


