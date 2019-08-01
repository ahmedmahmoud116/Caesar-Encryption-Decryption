package pkj;

public class CaesarCipherOOP {
	private String alphabet;
	private String shiftedAlphabet;
	private int mainkey;
	
	public CaesarCipherOOP() {
		
	}
	
	public CaesarCipherOOP(int key) {
		this.mainkey = key;
		alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
	}
	
	public String encrypt(String input){
		StringBuilder phrase = new StringBuilder(input);
		for(int i = 0;i<phrase.length();i++) {
			char test = phrase.charAt(i);
			int indx  = alphabet.indexOf(test);;
			if(indx != -1) {
				phrase.setCharAt(i, shiftedAlphabet.charAt(indx));
			}
			indx = alphabet.toLowerCase().indexOf(test);
			if(indx != -1) {
				phrase.setCharAt(i, shiftedAlphabet.toLowerCase().charAt(indx));
			}
		}
		return phrase.toString();
	}
	
	public String decrypt(String input) {
		CaesarCipherOOP cb = new CaesarCipherOOP(26 - mainkey);
		return cb.encrypt(input);
	}
}
