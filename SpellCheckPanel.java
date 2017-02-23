import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class SpellCheckPanel extends JPanel {
	//private Hashtable<Character, String> currentDict;
	private JButton addWord;
	private JButton ignoreWord;
	private JButton textButton;
	private JButton dictButton;
	//private JFileChooser textChoice;
	//private JFileChooser dictChoice;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JPanel inputPanel;
	private JPanel selectPanel;
	private JScrollPane viewText;
	
	public SpellCheckPanel() {
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		inputPanel = new JPanel();
		selectPanel = new JPanel();
		viewText = new JScrollPane();
		textButton = new JButton("Open a file...");
		FileListener textListener = new FileListener();
		textButton.addActionListener(textListener);
		dictButton = new JButton("Open a dictionary...");
		FileListener dictListener = new FileListener();
		dictButton.addActionListener(dictListener);
		addWord = new JButton("Add Word to Dictionary");
		AddListener addListener = new AddListener();
		addWord.addActionListener(addListener);
		ignoreWord = new JButton("Ignore Word");
		IgnoreListener ignoreListener = new IgnoreListener();
		ignoreWord.addActionListener(ignoreListener);
		//textChoice = new JFileChooser();
		//dictChoice = new JFileChooser();
		
		inputPanel.setLayout(new GridLayout(2, 1));
		inputPanel.add(textButton);
		inputPanel.add(dictButton);
		selectPanel.setLayout(new GridLayout(2, 1));
		selectPanel.add(addWord);
		selectPanel.add(ignoreWord);
		leftPanel.setLayout(new GridLayout(2, 1));
		leftPanel.add(inputPanel);
		leftPanel.add(selectPanel);
		
		viewText.setPreferredSize(new Dimension(300, 400));
		rightPanel.add(viewText);
		
		setLayout(new GridLayout(1, 2));
		add(leftPanel);
		add(rightPanel);
	}
	
	private class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			//add word
		}
	}
	
	private class IgnoreListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			//ignore word
		}
	}
	
	private class FileListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == textButton) {
				//open file
			} else {
				//open dictionary
			}
		}
	}
}
