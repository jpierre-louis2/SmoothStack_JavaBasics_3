//Author: Jameson Pierre-Louis
//This counts the number of times a particular character appears in a file.
package com.ss.apr.jb.three;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CharCounter {

	
	//An Overloaded character counter function where we can prompt user for input through scanner
	public static void charCounter(Scanner scan, File file) {
		
		int count = 0;
		
		System.out.print("What character would you like to search for: ");
		char target = scan.next().charAt(0);
		
		//Prints out contents and counts for desired character
		System.out.println("\nPrinting out File Contents:");
		try(FileReader fr = new FileReader(file)){
			int content;
			while((content = fr.read()) != -1){
				if(((char) content) == target) {
					++count;
				}
				System.out.print((char) content);
			}
		}
		catch(IOException e) {
			System.out.println("An error occured!");
			e.printStackTrace();
		}

		
		System.out.println("\n\n" + "Character '" + target + "' occurs " + count + " times");
	}
	
	
	
	//This function tallies the amount of the desired character and prints out file contents
	public static void charCounter(char target, File file) {
		
		int count = 0;
		
		//Prints out contents and counts for desired character
		System.out.println("\nPrinting out File Contents:");
		try(FileReader fr = new FileReader(file)){
			int content;
			while((content = fr.read()) != -1){
				if(((char) content) == target) {
					++count;
				}
				System.out.print((char) content);
			}
		}
		catch(IOException e) {
			System.out.println("An error occured!");
			e.printStackTrace();
		}
		
		System.out.println("\n\n" + "Character '" + target + "' occurs " + count + " times");
	}
	
	
	
	public static void main(String[] args) {
		
		char input = args[0].charAt(0);
		boolean one = true;
		
		//Checks for more than one input on Command Line
		if(args[0].length() > 1 || args.length > 1) {
			System.out.println("Error: More than 1 arguement detected on command line!");
			one = false;
		}
		if (one) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Please enter a File to letter count: ");
			String countFile = scan.nextLine();
			File file = new File(countFile);
			if(file.exists()) {
				charCounter(input, file);
				scan.close();
			}
			else {
				System.out.println("\nError: File not found!");
			}
		}
		
	}
}
