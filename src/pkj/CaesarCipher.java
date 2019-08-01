package pkj;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CaesarCipher {
	private void x() {
	}
	public CaesarCipher() {
		
	}
	
	public String encrypt(String input,int key){
		StringBuilder phrase = new StringBuilder(input);
		String alphabetic = new String("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		String part = alphabetic.substring(0,key);
		String newest = alphabetic.substring(key) + part;
		for(int i = 0;i<phrase.length();i++) {
			char test = phrase.charAt(i);
			int indx  = alphabetic.indexOf(test);
			if(indx != -1) {
				phrase.setCharAt(i, newest.charAt(indx));
			}
			indx = alphabetic.toLowerCase().indexOf(test);
			if(indx != -1) {
				phrase.setCharAt(i, newest.toLowerCase().charAt(indx));
			}
		}
		return phrase.toString();
	}
	
	public void testCaesar() throws FileNotFoundException {
		
		int key = 17;
		DirectoryResource dr = new DirectoryResource();
		for(File f: dr.selectedFiles()) {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(f);
			while(sc.hasNext()) {
				System.out.println(encrypt(sc.nextLine(), key));
			}
		}
	}
	
	public String encryptTwoKeys(String input,int key1 , int key2) {
		StringBuilder phrase = new StringBuilder(input);
		for(int i = 0 ; i<phrase.length();i++) {
			if(i%2 == 0) {
				String ch = encrypt(Character.toString(phrase.charAt(i)), key1);
				phrase.setCharAt(i, ch.charAt(0));
			}
			else {
				String ch = encrypt(Character.toString(phrase.charAt(i)), key2);
				phrase.setCharAt(i, ch.charAt(0));
			}
		}
		return phrase.toString();
	}
	
	public void testTwoKeys() {
		int key1 = 15;
		int key2 = 15;
		String phrase = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
		String encrypted = encryptTwoKeys(phrase, key1, key2);
		System.out.println("key1 is " + key1 + " key2 is " + key2 + ":\n" + encrypted);
	}
}
