package com.greatlearning.execution;

import java.util.Random;
import java.util.Scanner;

import com.greatlearning.modle.employee;

public class AdministratorMain {

	static Scanner sc = new Scanner(System.in);
	static String department = "";
	
	public static void main(String[] args) {
		showcredentials();
		generateEmailAddress();
		
	}
	
	private static void showcredentials() {
		System.out.println("Please enter the department from the following...");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		  int dep = sc.nextInt();
		  if(dep==1){department="tech";}
		  if(dep==2){department ="admin";}
		  if(dep==3){department ="hr";}
		  if(dep==4){department ="legal";}
		  
	}
	private static void generateEmailAddress() {
		System.out.println("Please enter the first Name");
		String fName = sc.next();
		
		System.out.println("Please enter the Last Name");
		String lName = sc.next();
		
		employee emp = new employee();
		emp.setFirstName(fName);
		emp.setLastName(lName); 
		

		System.out.println("Dear" +" "+emp.getFirstName()+" " + "your generated credentials are as follows");
		System.out.println("Email -->" +emp.getFirstName()+emp.getLastName()+"@"+department+".abc.com");
		System.out.println("Password -->" +generatePassword(8)); 	
	}
	
	 private static char[] generatePassword(int length) {
	
		  String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[length];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< length ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return password;
	   }
	
}
