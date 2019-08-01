package pkj;

import java.io.FileNotFoundException;

public class Tester {
	public Tester() {
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Word wd = new Word();
//		wd.testVowel();
//		wd.testreplace();
//		wd.testemphasize();
		CaesarCipher cc = new CaesarCipher();
		System.out.println(cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?", 15));
//		cc.testCaesar();
		cc.testTwoKeys();
		WordLength wl = new WordLength();
//		wl.testCountWordLengths();
		CaesarBreaker cb = new CaesarBreaker();
//		cb.testDecrypt();
//		cb.testHalf();
//		cb.testdTwoKeys();
//		System.out.println(cb.decryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!"));
		TestCaesarCipher tc = new TestCaesarCipher();
//		System.out.println(tc);
//		tc.simpleTests();
		TestCaesarCipherTwo tct = new TestCaesarCipherTwo();
//		tct.simpleTests();
	}

}
