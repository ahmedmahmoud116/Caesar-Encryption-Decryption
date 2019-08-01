package pkj;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordLength {
	public WordLength() {
		
	}
	
	public int[] countWordLengths(File f,int[] counts) throws FileNotFoundException {
		Scanner sc = new Scanner(f);
		while(sc.hasNext()) {
			String s = sc.next();
			int length = s.length();
			if(!Character.isAlphabetic(s.charAt(0)))
			length--;
			if(!Character.isAlphabetic(s.charAt(s.length() - 1)))
				length--;
			if(length>= counts.length) {
				counts[counts.length - 1]++;
			}
			else if(length >= 0)
			counts[length]++;
		}
		sc.close();
		return counts;
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
	public void testCountWordLengths() throws FileNotFoundException {
		DirectoryResource dr = new DirectoryResource();
		int[] counts = new int[31];
		for(File f : dr.selectedFiles()) {
			counts = countWordLengths(f, counts);
			System.out.println("for file name " + f.getName());
			for(int i = 1 ; i<counts.length; i++) {
				if(counts[i] == 0)
					continue;
				System.out.println(counts[i] + " words of length " + i);
			}
		}
		int max = indexOfMax(counts);
		System.out.println("the maximum index is: " + max);
	}
}
