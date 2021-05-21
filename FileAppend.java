//Author: Jameson Pierre-Louis
//This Program appends text to an existing file
package com.ss.apr.jb.three;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class FileAppend {
	
	
	//This function prints out file Content
	public static void fileRead(String fileName) {
		System.out.println("\nPrinting File:");
		try {
			File file = new File(fileName);
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String data = scan.nextLine();
				System.out.println(data);
			}
			scan.close();
		} catch (Exception e) {
			System.out.println("An error occured while printing!");
			e.printStackTrace();
		}
	}
	
	
	//This function appends a file (Adds Text)
	public static void appendAFile(){
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a File to Append: ");
		String appendFile = scan.nextLine();
		File file = new File(appendFile);
		
		if(file.exists()) {
			System.out.print("What is the text you would like to add: ");
			String appendText = scan.nextLine();
			
			try(FileOutputStream outputStream = new FileOutputStream(appendFile, true)){
				byte[] strToBytes = appendText.getBytes();
				outputStream.write(strToBytes);
				fileRead(appendFile);
				outputStream.close();
			}catch(IOException e) {
				System.out.println("Error occured while appending file!");
			}
		}
		else {
			System.out.println("\nError: Cannot find file!");
		}
		scan.close();
	}
	

	public static void main(String[] args){
		appendAFile();
	}

	
}
