import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

/**/

public class Source {
	
	public static final double CORRECT_PERCENT = 0.95; //What percent of words need to be real for it to work?
	
	public static ArrayList<String> dictionary;
	public static HashMap<String, String> frequencyHash;
	public static HashMap<String, Double> letterFrequencies;
	public static void main(String[] args) {
		/** SET UP VARS**/
		String code = "hi my name is"; 
		dictionary = new ArrayList<String>();
		try {
			readDictionary("wordlist.txt"); //Create a 'dictionary' for all words
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		letterFrequencies = findFrequencies(code); //Find the frequency of letters in the code
		try {
			frequencyHash = createFrequencyHash("wordfrequency.txt", letterFrequencies);  //Create a hash map replacing letters based on their frequency
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		CodeCracker cracker = new CodeCracker(code);
		/**  TESTING PHASES  **/
		int attempts = 0;
		while(!isCorrect(code) && attempts <= 3) { //FIRST TEST: No change
			switch(attempts) {
				case 0: //SECOND TEST: Replace letters with pure frequency list
					code = cracker.swapLetters(frequencyHash);
					break;
				case 1: //THIRD TEST: Plug in 'i' and 'a' to all combinations of single words
					
					break;
				case 2: //FOURTH TEST:
					
					break;
				case 3: //FIFTH TEST:
					
					break;
			}
				
			attempts ++;
		}
		
		if(attempts > 3) {
			System.out.println("UNABLE TO SOLVE CRYPTOGRAM");
		}
		else {
			System.out.println("CRYPTOGRAM SOLVED");
			System.out.println("Code:");
			System.out.println(code);
		}
	}
	
	public static void readDictionary(String file) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader(file));
        while (sc.hasNextLine()) {
            String text = sc.nextLine();
            dictionary.add(text.toLowerCase());
        }
        Collections.sort(dictionary);
	}
	
	public static boolean isCorrect(String txt) {
		String[] words = txt.split(" ");
		int numCorrect = 0;
		for(int i = 0; i < words.length; i ++) {
			int loc = Collections.binarySearch(dictionary, words[i].toLowerCase());
			if(loc >= 0) {
				numCorrect ++;
			}
		}	
		return (float) (numCorrect) / (float) (words.length) >= CORRECT_PERCENT;		
	}
	
	public static HashMap<Double, String> findFrequencies(String txt) { //returns the amount of times each letter shows up, sorted a-z
		// Not the most efficient way to do this, but it works...
		HashMap<Double, String> frequencies = new HashMap<Double, String>();
		String txtFormatted = txt.replaceAll(" ", "");
		for(int i = 0; i < txtFormatted.length(); i ++) {
			String val = String.valueOf(txtFormatted.charAt(i));
			frequencies.containsValue(value){
				frequencies.
			}
			if(frequencies.containsKey(val)) {
				frequencies.replace(val, frequencies.get(val) + 1);
			}
			else {
				frequencies.put(val, 1.0);
			}
		}
		return frequencies;
	}
	
	public static HashMap<String, String> createFrequencyHash(String file, HashMap<String, Double> frequencyList) throws FileNotFoundException {
		//Read the frequency text file
		HashMap<String, Double> realFrequencies = new HashMap<String, Double>();
		Scanner sc = new Scanner(new FileReader(file));
		int counter = 0;
        while (sc.hasNextLine()) {
            String[] text = sc.nextLine().split(" ");
            realFrequencies.put(text[0], Double.parseDouble(text[1]));
           	counter ++;
        } 
		realFrequencies.;
		
		return frequencyHash;
	}
}