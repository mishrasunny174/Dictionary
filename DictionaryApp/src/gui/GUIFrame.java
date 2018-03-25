package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIFrame {
	private JFrame app = null;
	private JLabel mainLabel = null;
	private JPanel mainLabelPanel = null;
	private JButton searchButton = null;
	private JTextField searchField = null;
	private JLabel searchLabel = null;
	private JPanel searchPanel = null;

	public GUIFrame(String title) {
		app = new JFrame(title);
		mainLabel = new JLabel("Dictionary");
		mainLabelPanel = new JPanel();
	}

	public void init() {
		app.setSize(new Dimension(400, 400));
		app.setLayout(new GridLayout(5, 1, 10, 0));
		mainLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		mainLabelPanel.add(mainLabel);
		app.add(mainLabelPanel);
		searchLabel = new JLabel("Query: ");
		searchLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
		searchField = new JTextField(20);
		searchButton = new JButton("Search");
		searchButton.addActionListener(new SearchButtonListener(this));
		searchPanel = new JPanel();
		searchPanel.add(searchLabel);
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		app.add(searchPanel);
	}

	public void run() {
		app.setVisible(true);
	}

}
