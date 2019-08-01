package pkj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCaesarCipherTwo {
	
	public TestCaesarCipherTwo() {
		
	}
	
	public String halfOfString(String message,int start) {
		StringBuilder sb = new StringBuilder();
		for(int i = start ; i<message.length();i= i+2) {
			sb.append(message.charAt(i));
		}
		return sb.toString();
	}
	
	public int[] countLetters(String phrase) {
		String alphabetic = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		int[] freq = new int[26];
		for(int i = 0; i < phrase.length() ; i++) {
			char test = Character.toUpperCase(phrase.charAt(i));
			int indx  = alphabetic.indexOf(test);
			if(indx != -1)
			{
				freq[indx]++;
			}
		}
		return freq;
	}
	
	public int  indexOfMax(int[] values) {
		int max = 0;
		for(int i = 1 ; i<values.length; i++) {
			if(values[i] > values[max]) {
				max = i;
			}
		}
		return max;
	}
	
	public int getKey(String s) {
		int[] freq = countLetters(s);
		int maxindx = new WordLength().indexOfMax(freq);
		return maxindx;
	}
	
	public void simpleTests() throws FileNotFoundException {
		
		StringBuilder sb = new StringBuilder();
		DirectoryResource dr = new DirectoryResource();
		for(File f : dr.selectedFiles()) {
			Scanner sc = new Scanner(f);
			while(sc.hasNext()) {
			sb.append(sc.next());
			sb.append(" ");
			}
			sc.close();
		}
		CaesarCipherTwoOOP cc = new CaesarCipherTwoOOP(21,8);
		System.out.println(cc);
		String encrypted = cc.encrypt(sb.toString());
		System.out.println("Encrypted: " + encrypted);
		System.out.println("Decrypted: " + cc.decrypt(encrypted));
		System.out.println("Auto Decrypted: " + breakCaesarCipher(sb.toString()));
	
	}
	
	public String breakCaesarCipher(String input) {
		
		String firsthalf = halfOfString(input, 0);
		String secondhalf = halfOfString(input, 1);
		int key1 = getKey(firsthalf);
		int key2 = getKey(secondhalf);
		int dkey1 = key1 - 4;
		if(key1 < 4) {
			dkey1 = 26 - (4 - key1);
		}
		int dkey2 = key2 - 4;
		if(key2 < 4) {
			dkey2 = 26 - (4 - key2);
		}
		System.out.println("Key1,Key2 is: " + dkey1 + ","+ dkey2);
		CaesarCipherTwoOOP ct = new CaesarCipherTwoOOP(dkey1,dkey2);
		return ct.decrypt(input);	
	}
	
}
