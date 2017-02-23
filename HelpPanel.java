import javax.swing.*;

public class HelpPanel extends JPanel {
	private JTextArea help;
	public HelpPanel() {
		help = new JTextArea("help me");
		help.setOpaque(false);
		help.setEditable(false);
		add(help);
	}
}