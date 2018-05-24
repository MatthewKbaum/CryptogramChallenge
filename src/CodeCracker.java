import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class CodeCracker {
	private String code = "";
	private ArrayList<String> dictionary;
	
	public CodeCracker(String code) {
		this.code = code;
		dictionary = new ArrayList<String>();
	}
	
	//Replaces letter in text with corresponding letter
	public String swapLetters(HashMap<String, String> swapper) {
		String[] letters = code.split("");
		for(int i = 0; i < letters.length;  i ++) {
			if(swapper.containsKey(letters[i])) {
				letters[i] = swapper.get(letters[i]);
			}
		}

		return code;
	}
		
	public String toString() {
		return code;
	}
}
