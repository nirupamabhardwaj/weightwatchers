package com.weightwatchers.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Iterator;

/*
 * Checks if the file exists.
 * If the file exists, read the file to get key value pairs and store them in HashMap.
 * File needs to have entries in: key-value1,value2...,valueN format.
 * File should be present in root folder of the project.
 */
public class ReadFile {

	public static boolean doesFileExist(String filePath)
	{
		
		File f = new File("./"+filePath);
		if(f.exists() && !f.isDirectory())
		{
			return true;
		}
		return false;
		
	}
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the file path:");
		String filePath = in.nextLine();
		in.close();
		boolean fileExist = doesFileExist(filePath);
		Map<String,String[]> dictionary = new HashMap<String,String[]>();
		if(fileExist)
		{
			try {
				BufferedReader br = new BufferedReader(new FileReader(filePath));
				String line;
				while((line = br.readLine()) != null){
					String key = line.split("-")[0];
					String values = line.split("-")[1];
					dictionary.put(key, values.split(","));
					
				}
				br.close();
			} catch(IOException ex) {
				System.out.println("FIle does not exist:" +ex.getMessage());
			} catch (Exception ex) {
				System.out.println("File may not be the right format- key-value1,value2,...,valueN:" +ex.getMessage());
				throw ex;
			}
			Iterator<String> it = dictionary.keySet().iterator();
			while(it.hasNext()){
				
				String word = it.next();
				System.out.println(word);
				String[] meanings = dictionary.get(word);
				for(int i=0; i< meanings.length; i++){
					System.out.println(meanings[i].trim());
				}
			}
		}
		else {
			System.out.println("FIle DOesnot Exist");
		}
	}
}

				