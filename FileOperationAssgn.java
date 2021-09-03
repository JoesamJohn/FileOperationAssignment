package com.simplilearn.fileoperationassignment;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FileOperationAssgn {
	
	static Scanner scanObj = new Scanner(System.in);

	public static void CreateFile(String sFileName) throws IOException{
		File file = new File(sFileName);
		
		if(file.createNewFile()) {
			System.out.println("File Created Successfully");
		}
		else {
			System.out.println("File Already Exists");
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Enter the operation to be performed: 1. Create File, 2.Read File, "
				+ "3. Write to File, 4. Append to File, 5. Exit");
		int nOpnType = scanObj.nextInt();
		
		String sFileName, sDirectoryName;
		sDirectoryName = "C://Users//JOESAM//Desktop//Data//Simplilearn//";
		
		if(nOpnType == 1) {
			System.out.println("Enter the File Name with extension");
			sFileName = scanObj.next();
			
			sFileName = sDirectoryName + sFileName;
			CreateFile(sFileName);			
		}
		else if(nOpnType == 2) {
			System.out.println("Enter the File Name with extension");
			sFileName = scanObj.next();
			
			sFileName = sDirectoryName + sFileName;
			ReadFileNIO(sFileName);
			
		}
		else if(nOpnType == 3) {
			System.out.println("Enter the File Name with extension");
			sFileName = scanObj.next();
			
			sFileName = sDirectoryName + sFileName;
			WriteToFileNIO(sFileName);
		}
		else if(nOpnType == 4) {
			System.out.println("Enter the File Name with extension");
			sFileName = scanObj.next();
			
			sFileName = sDirectoryName + sFileName;
			AppendToFileNIO(sFileName);
		}
		else if(nOpnType == 5) {
			System.exit(0);
		}
	}

	private static void AppendToFileNIO(String sFileName) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanObj1 = new Scanner(System.in);
		String sDataToWrite;
		int nFlag = 1;
		
		do {
			System.out.println("Enter the data to be written to the File: ");
			sDataToWrite = scanObj1.nextLine();
			System.out.println(sDataToWrite);
			
			List<String> lines = Arrays.asList(sDataToWrite);
			Files.write(Paths.get(sFileName), lines, StandardCharsets.UTF_8,StandardOpenOption.CREATE,StandardOpenOption.APPEND);
			
			System.out.println("Do you want to append another line (1: Yes): ");
			int nCount = scanObj.nextInt();
			if(nCount == 1) continue;
			else break;
		}while(nFlag == 1);		
	}

	private static void WriteToFileNIO(String sFileName) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanObj1 = new Scanner(System.in);
		String sDataToWrite;
		int nFlag = 1;
		
		do {
			System.out.println("Enter the data to be written to the File: ");
			sDataToWrite = scanObj1.nextLine();
			System.out.println(sDataToWrite);
			
			List<String> lines = Arrays.asList(sDataToWrite);
			Files.write(Paths.get(sFileName), lines, StandardCharsets.UTF_8,StandardOpenOption.CREATE);
			
			System.out.println("Do you want to write another line (1: Yes): ");
			int nCount = scanObj.nextInt();
			if(nCount == 1) continue;
			else break;
		}while(nFlag == 1);
	}

	private static void ReadFileNIO(String sFileName) {
		// TODO Auto-generated method stub
		List<String> lines1 = Collections.emptyList();
		try {
			lines1 = Files.readAllLines(Paths.get(sFileName),StandardCharsets.UTF_8);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		System.out.println(lines1);
	}
}