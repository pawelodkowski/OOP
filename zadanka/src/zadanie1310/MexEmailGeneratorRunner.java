package zadanie1310;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MexEmailGeneratorRunner {

	public static void main(String[] args) throws IOException {

		/*for(String l:addLabours()) {
			System.out.println(l.toString());
		}*/
		addLaboursAndWriteToFile();
		
		
		

	}
		private static List<String> addLabours() {
			List<String> emailList = new ArrayList<>();
			String name, surname, email;
			Scanner scan = new Scanner(System.in);
			boolean loopFunction = true;
			int i = 1;
			while(loopFunction) {
				System.out.println("Name: ");
				name = scan.nextLine().trim();
				System.out.println("Surname: ");
				surname = scan.nextLine().trim();
				email = name.toLowerCase()+"."+surname.toLowerCase()+"@mex.com";
					if(emailList.contains(email)) {
						System.out.println("exists already, so that one must have a number");
						email = name.toLowerCase()+"."+surname.toLowerCase()+i+"@mex.com";
						++i;
					}
				emailList.add(email);
				boolean nextUserLoop = true;
				System.out.println("Wanna add next?\n"
						+ "y for yes, n for no");
				String decision = scan.nextLine().trim().toLowerCase();
				switch(decision) {
				case "n": 
					loopFunction = false;
				break;
				case "y":
					continue;
				default: {
					while (nextUserLoop) {
						System.out.println("no such option!\n"
								+ "if u want to create next type y if no type n and hit enter");
						decision = scan.nextLine().trim().toLowerCase();
						if (decision.equalsIgnoreCase("n")) {
							nextUserLoop = false;
							loopFunction = false;
						}
						if (decision.equalsIgnoreCase("y")) {
							nextUserLoop = false;
						}
					}
					}
				}
				}
			return emailList;
		}

		private static void addLaboursAndWriteToFile() throws IOException{
			String name, surname, email;
			Scanner scan = new Scanner(System.in);
			boolean enterUsersLoop = true;
			int i = 1;
			Path emailsFilePath = Paths.get("D:\\emailsDB\\emails.txt");
			
			try {
				
				Files.createFile(emailsFilePath);
				
			} catch (FileAlreadyExistsException e) {
				
				System.out.println("File already exists.");
				
			}
			//reading an email file 
			List<String> emailList = new ArrayList<>(readFileInList("D:\\emailsDB\\emails.txt"));
			
			while(enterUsersLoop) {
				System.out.print("Enter your ");
				System.out.println("name: ");
				name = scan.nextLine().trim();
				
				System.out.println("surname: ");
				surname = scan.nextLine().trim();
				
				email = name.toLowerCase()+"."+surname.toLowerCase()+"@mex.com";
				
				// checking if exists new created email in "DB"
					if(emailList.contains(email)) { 
						
						System.out.println("exists already, so that one must have a number");
						email = name.toLowerCase()+"."+surname.toLowerCase()+i+"@mex.com"; //if exists adding number it at the end
						
						++i;
						
					}
				emailList.add(email);
				//add email to list of emails
				writeStringToFile(email, "D:\\emailsDB\\emails.txt");
				
				System.out.println("Wanna add next?\n"
							+ "y for yes, n for no");
				String decision = scan.nextLine().trim().toLowerCase();
				
				boolean nextUserLoop = true;
				
				switch(decision) {
					case "n": 
						
						enterUsersLoop = false;
						break;
					
					case "y":
						
						continue;
						
					default: {
						
						while (nextUserLoop) {
							System.out.println("no such option!\n"
									+ "if u want to create next type y if no type n and hit enter");
							decision = scan.nextLine().trim().toLowerCase();
							
							if (decision.equalsIgnoreCase("n")) {
								
								nextUserLoop = false;
								enterUsersLoop = false;
								
							}
							if (decision.equalsIgnoreCase("y")) {
								
								nextUserLoop = false;
								
							}
						}
					}
				}
				}
		/*	for(int j = 0; j < emailList.size(); j++) {
				
				BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\emailsDB\\emails.txt", true));
				writer.newLine();
				writer.append(emailList.get(j));
				writer.close();
				
			} */
		}
		public static List<String> readFileInList(String fileName) {
			
		    List<String> lines = Collections.emptyList(); 
		    try
		    { 
		      lines = 
		       Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8); 
		    } 
		  
		    catch (IOException e) 
		    { 
		  
		      e.printStackTrace(); 
		      
		    } 
		    return lines; 
			
		
		}
		public static void writeStringToFile(String data, String destination) throws IOException {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(destination, true));
			writer.append(data);
			writer.newLine();
			writer.close();
			
		}
}

