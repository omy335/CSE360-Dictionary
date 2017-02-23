import javax.swing.*;
import java.util.*;
import java.awt.Container;
import java.awt.event.*;

public class SpellCheck extends JFrame {
	/*private SpellCheckPanel spellCheckPanel;
	private HelpPanel helpPanel;
	private DictPanel dictPanel;
	private JTabbedPane tPane;
	private Hashtable<Character, String> currentDict;*/
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Indecisive");
		
		Hashtable<Character, String> currentDict = new Hashtable<Character, String>(); //placeholders
		currentDict.put('a', "stuff");
		currentDict.put('b', "more stuff");
		
		JFileChooser saveDict = new JFileChooser();
		SpellCheckPanel spellCheckPanel = new SpellCheckPanel();
		HelpPanel helpPanel = new HelpPanel();
		DictPanel dictPanel = new DictPanel(currentDict);
		JTabbedPane tPane = new JTabbedPane();
		tPane.addTab("Spell Checker", spellCheckPanel);
		tPane.addTab("Help", helpPanel);
		tPane.addTab("Current Dictionary", dictPanel);
		
		Container container = frame.getContentPane();
		container.add(tPane);
		//getContentPane().add(tPane);
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				int answer = JOptionPane.showConfirmDialog(frame, "Do you want to save the dictionary before exiting?", "Save Dictionary", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				if (answer == JOptionPane.YES_OPTION) {
					//save file
				}
				System.exit(0);
			}
		});
	}
}