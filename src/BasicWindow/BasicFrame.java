package BasicWindow;

import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class BasicFrame extends JFrame{
	
	//-------------------------------------------
	// constructor that controls frame
	//-------------------------------------------
	public BasicFrame() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 513);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("PIG LATIN TRANSLATOR");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BasicWindow_Main.class.getResource("/images/pig1.png")));
		
		//-------------------------------------------
		// create and add panel
		//-------------------------------------------
		BasicPanel panel = new BasicPanel();
		
		add(panel);
		
		setVisible(true);
		
		createEvents();
	}
	
	//-------------------------------------------
	// method to control events
	//-------------------------------------------
	public void createEvents() {
		
		//-------------------------------------------
		// when close is selected prompt user 
		//-------------------------------------------
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e){
				
				int close = JOptionPane.showConfirmDialog(null, "\n  Would you like to close this application?        ", 
						"Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (close == JOptionPane.YES_OPTION) {
					BasicWindow_Main.outro();
					System.exit(0);;
				}
			 }
		});
	}

}
