/**
 * @author jacksteggles
 *
 */
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
public class Files {

	public static void delete()
	{
		System.out.println("Please enter the word in Englsh to delete: ");
		Scanner r = new Scanner(System.in);
		String english = r.nextLine();

		char[] characters = english.toCharArray();
		char firstChar = characters[0];
		
		PrintWriter pw = new PrintWriter(firstChar + "update.txt");
		BufferedReader br1 = new BufferedReader(new FileReader(firstChar + "old.txt"));
		String line1 = br1.readLine();
		
		while(line1 != null)
		{
			boolean flag = false;
			
			while(english != null)
			{
				if(line1.contentEquals(english))
				{
					flag = true;
					break;
				}
			}
			if(!flag)
				pw.println(line1);
			
			line1 = br1.readLine();
		}
		pw.flush();
		br1.close();
		pw.close();
	}
	
	public static void addEngToSpan() {
		FileOutputStream outputStream;
		PrintWriter printWriter;
		
		System.out.println("Please enter the word in Englsh to add: ");
		Scanner r = new Scanner(System.in);
		String english = r.nextLine();
		System.out.println("Please enter the word in Spanish to add: ");
		Scanner r = newScaner(System.in);
		String spanish = r.nextLine();
		
		char[] characters = english.toCharArray();
		char firstChar = characters[0];
		
		try (FileWriter f = new FileWriter(firstChar + ".txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);)
		{
			p.println(english + " - " + spanish);
		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void addSpanToEng() {
		FileOutputStream outputStream;
		PrintWriter printWriter;
		
		System.out.println("Please enter the word in Spanish to add: ");
		Scanner r = new Scanner(System.in);
		String spanish = r.nextLine();
		System.out.println("Please enter the word in English to add: ");
		Scanner r = newScaner(System.in);
		String english = r.nextLine();
		
		char[] characters = spanish.toCharArray();
		char firstChar = characters[0];
		
		try (FileWriter f = new FileWriter(firstChar + ".txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);)
		{
			p.println(spanish + " - " + english);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void copyFile() {
		FileReader fileReader;
		BufferedReader bufferedReader;
		String nextLine;
		FileOutputStream outputStream;
		PrintWriter printWriter;
		
		System.out.println("please enter name of file to be read: ");
		Scanner r = new Scanner(System.in);
		String read = r.nextLine();
		
		try {
			fileReader = new FileReader(read);
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream("write.txt");
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine();
			while (nextLine != null)
			{
				System.out.println(nextLine);
				printWriter.println(nextLine);
				nextLine = bufferedReader.readLine();
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void translateFile() {
		FileReader fileReader;
		BufferedReader bufferedReader;
		String nextLine;
		FileOutputStream outputStream;
		PrintWriter printWriter;
		
		try {
			fileReader = new FileReader("mystery.txt");
			bufferedReader = new BufferedReader(fileReader);
			outputStream = new FileOutputStream("decryptedFile.txt");
			printWriter = new PrintWriter(outputStream);
			
			nextLine = bufferedReader.readLine();
			while (nextLine != null)
			{
				String temp = Files.cipherDecipherString(nextLine); // translate
				printWriter.println(temp); 
				System.out.println(temp);
				nextLine = bufferedReader.readLine();
			}
			bufferedReader.close();
			printWriter.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	



	
