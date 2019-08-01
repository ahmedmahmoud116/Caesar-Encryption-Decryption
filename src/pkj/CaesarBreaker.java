package pkj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class CaesarBreaker {
	public CaesarBreaker(){
		
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
	public String decrypt(String encrypted) {
		CaesarCipher cc = new CaesarCipher();
		int[] freq = countLetters(encrypted);
		int maxindx = new WordLength().indexOfMax(freq);
		int dkey = maxindx - 4;
		if(maxindx < 4) {
			dkey = 26 - (4 - maxindx);
		}
		return cc.encrypt(encrypted,  26 - dkey);
	}
	
	public void testDecrypt() {
		CaesarCipher cc = new CaesarCipher();
		String input = "FREE CAKE IN THE CONFERENCE ROOM!";
		int key = 17;
		String encrypt = cc.encrypt(input, key);
		System.out.println(encrypt);
		System.out.println(decrypt(encrypt));
	}
	
	public String halfOfString(String message,int start) {
		StringBuilder sb = new StringBuilder();
		for(int i = start ; i<message.length();i= i+2) {
			sb.append(message.charAt(i));
		}
		return sb.toString();
	}
	
	public void testHalf() {
		System.out.println(halfOfString("Hello World", 2));
	}
	
	public int getKey(String s) {
		int[] freq = countLetters(s);
		int maxindx = new WordLength().indexOfMax(freq);
		return maxindx;
	}
	
	public String decryptTwoKeys(String encrypted) {
		
		CaesarCipher cc = new CaesarCipher();
		String firsthalf = halfOfString(encrypted, 0);
		String secondhalf = halfOfString(encrypted, 1);
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
		System.out.println("Key 1: "+ dkey1);
		System.out.println("Key 2: "+ dkey2);
		return cc.encryptTwoKeys(encrypted, 26-dkey1, 26-dkey2);
//		return cc.encryptTwoKeys(encrypted, 12, 2);
	}
	
	public void testdTwoKeys() throws FileNotFoundException {
		CaesarCipher cc= new CaesarCipher();
		DirectoryResource dr = new DirectoryResource();
		String s = cc.encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.", 8,21);
//		s = "";
//		StringBuilder sb = new StringBuilder();
//		
//		for(File f : dr.selectedFiles()) {
//			Scanner sc = new Scanner(f);
//			while(sc.hasNext()) {
//			sb.append(sc.next());
//			sb.append(" ");
//			}
//			s = decryptTwoKeys(sb.toString());
//			sc.close();
//		}
		s = decryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.");
		System.out.println(s);
	
	}
}
