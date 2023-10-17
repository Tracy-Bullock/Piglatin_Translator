package BasicWindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class BasicPanel extends JPanel{
	
	JButton btnTranslate, btnResetText;
	JTextArea textToTranslate, textTranslated;
	
	//-------------------------------------------
	// constructor to control Jpanel
	//-------------------------------------------
	public BasicPanel() {
		
		initComponents();
		createEvents();
	}
	
	//-------------------------------------------
	// method to initialize components
	//-------------------------------------------
	public void initComponents() {
		
		setLayout(null);
		setBackground(Color.CYAN);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		JLabel lblTitle = new JLabel("Translate any sentence to Pig Latin!");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitle.setBounds(69, 16, 299, 38);
		add(lblTitle);
		
		JLabel lblGetSentence = new JLabel("What would you like to translate?");
		lblGetSentence.setBounds(120, 72, 208, 14);
		add(lblGetSentence);
		
		JScrollPane scrTextToTranslate = new JScrollPane();
		scrTextToTranslate.setBounds(69, 104, 299, 119);
		add(scrTextToTranslate);
		
		textToTranslate = new JTextArea();
		textToTranslate.setBackground(Color.PINK);
		textToTranslate.setToolTipText("Type the desired text to be translated.");
		textToTranslate.setLineWrap(true);
		textToTranslate.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textToTranslate.setWrapStyleWord(true);
		scrTextToTranslate.setViewportView(textToTranslate);
		
		btnTranslate = new JButton("Translate");
		btnTranslate.setToolTipText("Click to translate text.");
		btnTranslate.setBounds(69, 234, 89, 23);
		add(btnTranslate);
		
		btnResetText = new JButton("Reset");
		btnResetText.setToolTipText("Click to reset the text.");
		btnResetText.setBounds(279, 234, 89, 23);
		add(btnResetText);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 268, 299, 119);
		add(scrollPane);
		
		textTranslated = new JTextArea();
		textTranslated.setBackground(Color.PINK);
		textTranslated.setEditable(false);
		textTranslated.setToolTipText("Your text will be translated here.");
		textTranslated.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textTranslated.setLineWrap(true);
		textTranslated.setWrapStyleWord(true);
		scrollPane.setViewportView(textTranslated);
	}
	
	//-------------------------------------------
	// method to create events
	//-------------------------------------------
	public void createEvents() {
		
		//-------------------------------------------
		// action listener for translate button
		//-------------------------------------------
		btnTranslate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Translate translation = new Translate(textToTranslate.getText().toLowerCase());
				if (translation.getTranslated().equalsIgnoreCase("#invalid#")) {
					clearTextFields();
				} else {
					textTranslated.setText(translation.getTranslated());
					textToTranslate.setEditable(false);
					textToTranslate.setToolTipText("Click reset to enter another sentence.");
					btnTranslate.setEnabled(false);
					textTranslated.setToolTipText("This is your translated text.");
				}
				
				
			}
		});
		
		//-------------------------------------------
		// action listener for reset button
		//-------------------------------------------
		btnResetText.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				clearTextFields();
				textToTranslate.setEditable(true);
				textToTranslate.setToolTipText("Type the desired text to be translated.");
				btnTranslate.setEnabled(true);
				textTranslated.setToolTipText("Your text will be translated here.");
				
			}
		});
		
	}
	
	//-------------------------------------------
	// method to clear text fields
	//-------------------------------------------
	public void clearTextFields() {
		
		textToTranslate.setText("");
		
		textTranslated.setText("");
	}

}
