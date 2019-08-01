package pkj;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestCaesarCipher {
	
	public TestCaesarCipher() {
		
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
		CaesarCipherOOP cc = new CaesarCipherOOP(15);
		String encrypted = cc.encrypt(sb.toString());
//		String encrypted = cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?");
		System.out.println("Encrypted: " + encrypted);
		System.out.println("Decrypted: " + cc.decrypt(encrypted));
		System.out.println("Auto Decrypted: " + breakCaesarCipher(encrypted));
	}
	
	public String breakCaesarCipher(String input) {
		int[] freq = countLetters(input);
		int maxindx = new WordLength().indexOfMax(freq);
		int dkey = maxindx - 4;
		if(maxindx < 4) {
			dkey = 26 - (4 - maxindx);
		}
		CaesarCipherOOP cc = new CaesarCipherOOP(dkey);
		return cc.decrypt(input);
	}
	
}
