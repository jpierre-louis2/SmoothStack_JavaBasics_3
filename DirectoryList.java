//Author: Jameson Pierre-Louis
//This Program lists all file/directory names (including subdirectories) under a given directory
package com.ss.apr.jb.three;
import java.io.File;
import java.util.Scanner;


public class DirectoryList {

	//This function Recursively lists all files/directories
	public static void listDirectoryFiles(File folder) {
		
		try {
			for(File file : folder.listFiles()) {
				//Checks if file is marked as a directory
				if(file.isDirectory()) {
					System.out.println("\nSubDirectory: " + file);
					listDirectoryFiles(file);
				}
				else {
					System.out.println(file.getName());
				}
			}
		}catch(Exception e){
			System.out.print("\nError directory not found!");
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Please enter a Directory to search: ");
		String direc = scan.nextLine();
		File folder = new File (direc);
		
		if(folder.exists())
			System.out.println("\nSearching through Directory: " + direc);
		
		listDirectoryFiles(folder);
		scan.close();
	}

}
