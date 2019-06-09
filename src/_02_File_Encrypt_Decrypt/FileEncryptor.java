package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	// Create a program that takes a message from the user.
	// Use the methods in the String and Character classes to save
	// an encrypted form of the message to a file
	
	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog("Give me a message.");
		String encrypted = "";
		for(int i = input.length()-1; i > -1; i--) {
		encrypted += input.substring(i, i+1);
		}
		
		
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/encryptedFile.txt");
			fw.write(encrypted);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
