package pkj;

public class Word {
	
	public Word() {
		
	}
	
	public boolean isVowel(char ch) {
		if(Character.isLowerCase(ch) && Character.isAlphabetic(ch)) {
			//'a', 'e', 'i', 'o', or 'u' 
			if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
				return true;
			}
			return false;
		}
		else if(Character.isUpperCase(ch) && Character.isAlphabetic(ch)){
			if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
				return true;
			}
			return false;
		}
		else
			return false;
	}
	
	public void testVowel() {
		System.out.println(isVowel('e'));
	}
	
	public String replaceVowels(String phrase,char ch) {
		StringBuilder sb = new StringBuilder(phrase);
		for(int i=0; i<sb.length(); i++) {
			if(isVowel(sb.charAt(i))) {
				sb.replace(i,i+1,Character.toString(ch));
			}
		}
		return sb.toString();
	}
	
	public void testreplace() {
		char ch = '*';
		String test  = "Hello World";
		String s = replaceVowels(test, ch);
		System.out.println(s);
	}
	
	public String emphasize(String phrase,char ch) {
		StringBuilder sb = new StringBuilder(phrase);
		for(int i = 0 ; i<sb.length();i++) {
			if(sb.charAt(i) == Character.toLowerCase(ch) || sb.charAt(i) == Character.toUpperCase(ch)) {
				if(i % 2 == 0) {
				sb.replace(i,i+1,"*");
				}
				else
				sb.replace(i,i+1,"+");
			}
		}
		return sb.toString();
	}
	
	public void testemphasize() {
		String phrase = "Mary Bella Abracadabra";
		char ch = 'a';
		String test = emphasize(phrase, ch);
		System.out.println(test);
	}
}
