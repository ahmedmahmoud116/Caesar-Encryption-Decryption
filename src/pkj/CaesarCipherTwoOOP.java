package pkj;

public class CaesarCipherTwoOOP {
	
	private String alphabet;
	private String shiftedAlphabet1;
	private String shiftedAlphabet2;
	private int mainkey1;
	private int mainkey2;
	
	public CaesarCipherTwoOOP() {
		
	}
	
	public CaesarCipherTwoOOP(int key1,int key2) {
		this.mainkey1 = key1;
		this.mainkey2 = key2;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
		shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
	}
	
	public String encrypt(String input) {
		StringBuilder phrase = new StringBuilder(input);
		for(int i = 0;i<phrase.length();i++) {
			char test = phrase.charAt(i);
			int indx  = alphabet.indexOf(test);;
			if(i%2 == 0) {
				if(indx != -1) {
					phrase.setCharAt(i, shiftedAlphabet1.charAt(indx));
				}
				indx = alphabet.toLowerCase().indexOf(test);
				if(indx != -1) {
					phrase.setCharAt(i, shiftedAlphabet1.toLowerCase().charAt(indx));
				}
			}
			else {
				if(indx != -1) {
					phrase.setCharAt(i, shiftedAlphabet2.charAt(indx));
				}
				indx = alphabet.toLowerCase().indexOf(test);
				if(indx != -1) {
					phrase.setCharAt(i, shiftedAlphabet2.toLowerCase().charAt(indx));
				}
			}
		}
		return phrase.toString();
	}
	
	public String decrypt(String input) {
		CaesarCipherTwoOOP ct = new CaesarCipherTwoOOP(26 - this.mainkey1, 26 - this.mainkey2);
		return ct.encrypt(input);
	}
	
}
