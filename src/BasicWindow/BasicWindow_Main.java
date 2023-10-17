/* 
 * NAME: Tracy Bullock
 * CLASS: CMIS 242 (2215)
 * DATE: June 11, 2021
 * 
 * This program is made to translate any word or sentence into pig latin.
 * The user can type what they desire to be translated into the text field
 * and press translate to translate it and then reset to start over. Only 
 * words that contain a vowel can be used. No numbers or symbols can be used.
 * 
 */

package BasicWindow;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class BasicWindow_Main {

	public static void main(String[] args) {
		
		//-------------------------------------------
		// customize JOptionPane Dialogs
		//-------------------------------------------
		JDialog.setDefaultLookAndFeelDecorated(true);
		UIManager UI = new UIManager();
		UI.put("OptionPane.messageFont", new FontUIResource("Tahoma", Font.BOLD, 16));
		UI.put("OptionPane.background", new ColorUIResource(Color.CYAN));
		UI.put("Panel.background", new ColorUIResource(Color.PINK));
		
		intro();
		
		//-------------------------------------------
		// create the jframe
		//-------------------------------------------
		BasicFrame frame = new BasicFrame();


	}
	
	//-------------------------------------------
	// method for introduction
	//-------------------------------------------
	public static void intro() {
		
		JOptionPane.showInternalMessageDialog(null, "\n      Welcome to the "
				+ "Pig Latin Translator.      \n" + 
				"\n             Avehay ayay eatgray imetay!\n ", 
				"WELCOME", JOptionPane.PLAIN_MESSAGE);
	}
	
	//-------------------------------------------
	// method for outro message
	//-------------------------------------------
	public static void outro() {
		
		JOptionPane.showInternalMessageDialog(null, "\n      Thank you for using the "
				+ "Pig Latin Translator.      \n" + 
				"\n                             Have a great day!\n ", 
				"GoodBye", JOptionPane.PLAIN_MESSAGE);
	}

}
