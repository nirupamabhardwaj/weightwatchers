package com.weightwatchers.test;
import java.util.Scanner;
/*
 * Program to reverse an entire string.
 * Execute the program and then enter the string you would like to reverse. 
 * Press enter after you type in the string to see the result.
 */
class ReverseString {

	public static void main(String args[]) 
	{
		String original;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the String to reverse");
		original = in.nextLine();
		in.close();
		System.out.println("Reverse string is: " +reverseEverything(original));
	}	
	
	public static String reverseEverything(String original)
	{
		String reverse = "";
		int length = original.length();
		for(int i = length-1; i>=0;i--)
			reverse = reverse + original.charAt(i);
		return reverse;
		
	}
}
