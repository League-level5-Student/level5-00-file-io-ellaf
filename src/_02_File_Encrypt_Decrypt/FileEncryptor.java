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
		String en1 = input.replaceAll("a", "&");
		String en2 = en1.replaceAll("e", "#");
		String en3 = en2.replaceAll("o", "^");
		String en4 = en3.replaceAll("i","!");
		String encrypted = en4.replaceAll("u", "@");
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
