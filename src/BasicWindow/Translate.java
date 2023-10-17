package BasicWindow;

import java.util.regex.Pattern;

import javax.swing.*;

//-------------------------------------------
// class to translate text
//-------------------------------------------
public class Translate {
	
	private String[] wordList;
	private String translated, checkInput;
	
	//-------------------------------------------
	// no-arg constructor
	//-------------------------------------------
	public Translate() {
		
		wordList = new String[] {"nothing", "to", "translate"};
		translated = "";
		checkInput = "#invalid#";
		
	}
	
	//-------------------------------------------
	// parameterized constructor
	//-------------------------------------------
	public Translate(String textToTranslate) {
		
		setWordList(textToTranslate);
		setTranslated(wordList);
		
	}

	//-------------------------------------------
	// method to retrieve word list
	//-------------------------------------------
	public String[] getWordList() {
		
		return wordList;
	}

	//-------------------------------------------
	// method to set the word list
	//-------------------------------------------
	public void setWordList(String textToTranslate) {
		
		wordList = textToTranslate.split(" ");
		
		for (String word : wordList) {
			
			if (Pattern.matches("[a-zA-Z]{1,20}", word)) {
				
				checkInput = "valid";
				
			} else {
				
				checkInput = "#invalid#";
				errMsg();
				break;
			}
		}
	}

	//-------------------------------------------
	// method to get the translated text
	//-------------------------------------------
	public String getTranslated() {
		return translated;
	}

	//-------------------------------------------
	// method to set the translated text
	//-------------------------------------------
	public void setTranslated(String[] wordList) {
		
		if (checkInput.equalsIgnoreCase("#invalid#")) {
			
			translated = checkInput;
			
		} else {
			int wordCount = 0;
			
			for (int count = 0; count < wordList.length; count++) {
				
				if (count == 0) {
					
					translated = translate(wordList[count]);
					translated = translated.substring(0,1).toUpperCase() + translated.substring(1);
					wordCount++;
					
				} else {
					
					translated += " " + translate(wordList[count]);
					wordCount++;
				}
				if (translated.contains("#invalid#")) {
					errMsg();
					break;
				}
				
			}
			
			if (wordCount > 1) {
				
				translated += ".";
			}
		}
	}
	
	//-------------------------------------------
	// method to translate each word
	//-------------------------------------------
	public String translate(String word) {
		
		int index = -1;
		
		for (int i = 0; i < word.length(); i++) {
			
			if (isVowel(word.charAt(i))) {
				
				index = i;
				break;
				
			}
		}
		if (index == -1) {
			
			return "#invalid#";
			
		} else if (index == 0) {
			
			return word + "yay";
			
		} else {
			
			return word.substring(index) + word.substring(0, index) + "ay";
		}
	}
	
	//-------------------------------------------
	// method to check if there is a vowel
	//-------------------------------------------
	public boolean isVowel(char ch) {   
		
		return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');   
	}
	
	//-------------------------------------------
	// method for error messages
	//-------------------------------------------
	public void errMsg() {
		
		ImageIcon icon = new ImageIcon(BasicWindow_Main.class.getResource("/images/pig2.png"));
		
		JOptionPane.showMessageDialog(null, "You can only enter real words with letters between a-Z !    ", 
				"ERROR", JOptionPane.ERROR_MESSAGE, icon);
	}
	
	

}
