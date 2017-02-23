import javax.swing.*;
import java.util.*;

public class DictPanel extends JPanel {
	private Hashtable<Character, String> currentDict;
	private JTextArea dictContent;
	
	public DictPanel(Hashtable<Character, String> currentDict) {
		this.currentDict = currentDict;
		dictContent = new JTextArea(currentDict.toString());
		dictContent.setOpaque(false);
		dictContent.setEditable(false);
		add(dictContent);
	}
}
