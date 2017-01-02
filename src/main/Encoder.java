package main;

import java.util.Random;
import java.util.Scanner;

public class Encoder {

	public static String encryptorID = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ,.'/?!@#$%^&*()=+-_1234567890 ";

	public static void encodeString(String str) {
		String output = "";
		String key = "";
		for (char a : str.toCharArray()) {
			int index = encryptorID.indexOf(a);
			int rand = new Random().nextInt(encryptorID.length() - (encryptorID.length() / 2));
			int sum = rand + index;
			if (!(sum > encryptorID.length() - 1)) {
				output += encryptorID.toCharArray()[sum];
				key += rand + " ";
			} else {
				sum -= encryptorID.length();
				output += encryptorID.toCharArray()[sum];
				key += rand + " ";
			}
		}
		System.out.println(output);
		System.out.println(key);
	}

	public static void main(String[] args) {
		System.out.println(encryptorID.length());
		while (true) {
			try {
				Scanner scanner = new Scanner(System.in);
				encodeString(scanner.nextLine());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
