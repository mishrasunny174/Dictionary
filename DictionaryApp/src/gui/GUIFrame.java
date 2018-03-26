package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GUIFrame {
	private JPanel app = null;
	private JLabel mainLabel = null;
	private JPanel mainLabelPanel = null;
	private JButton searchButton = null;
	private JTextField searchField = null;
	private JLabel searchLabel = null;
	private JPanel searchPanel = null;
	private JTabbedPane resultTabs = null;
	private JPanel resultHeaderPanel = null;
	private JLabel resultHeader = null;
	private JFrame appframe = null;
	private JLabel notSearchedLabel = null;
	private JPanel notSearchedPanel = null;
	
	public GUIFrame(String title) {
		appframe = new JFrame(title);
		appframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app = new JPanel();
		mainLabel = new JLabel("Dictionary");
		mainLabelPanel = new JPanel();
		searchLabel = new JLabel("Query: ");
		searchField = new JTextField(17);
		searchButton = new JButton("Search");
		searchPanel = new JPanel();
		resultHeaderPanel = new JPanel();
		resultHeader = new JLabel("Results");
		resultTabs = new JTabbedPane();
		notSearchedLabel = new JLabel("Please Search for something first!");
		notSearchedPanel = new JPanel();
	}

	public void init() {
		appframe.setSize(new Dimension(400, 400));
		appframe.add(app);
		appframe.setLayout(new GridLayout(1, 1));
		appframe.setResizable(true);
		appframe.setBackground(Color.WHITE);
		appframe.setMinimumSize(new Dimension(400, 400));
		app.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weighty = 0.5;
		Font mainFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
		mainLabel.setFont(mainFont);
		mainLabel.setForeground(Color.red);
		mainLabelPanel.add(mainLabel);
		mainLabelPanel.setAlignmentY(SwingConstants.CENTER);
		app.add(mainLabelPanel, gbc);
		gbc.gridy = 1;
		gbc.weighty = 0;
		app.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
		searchLabel.setFont(font);
		searchButton.addActionListener(new SearchButtonListener(this));
		searchPanel.add(searchLabel);
		searchPanel.add(new JSeparator(SwingConstants.VERTICAL));
		searchField.setFont(font);
		searchField.setText("");
		searchField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode()==KeyEvent.VK_ENTER) {
					searchButton.doClick();
				}
			}
		});
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		app.add(searchPanel, gbc);
		gbc.gridy = 3;
		app.add(new JSeparator(SwingConstants.HORIZONTAL), gbc);
		gbc.gridy = 4;
		gbc.weighty = 0;
		resultHeader.setFont(mainFont);
		resultHeader.setForeground(Color.BLACK);
		resultHeaderPanel.add(resultHeader);
		app.add(resultHeaderPanel, gbc);
		gbc.gridy=5;
		gbc.weighty=1;
		resultTabs.setVisible(false);
		app.add(resultTabs,gbc);
		notSearchedPanel.add(notSearchedLabel);
		app.add(notSearchedPanel,gbc);
	}

	public void run() {
		appframe.setVisible(true);
	}

	public String getQuery() {
		return searchField.getText();
	}

	public JTabbedPane getResultsTabbedPane() {
		return resultTabs;
	}
	
	public JFrame getFrame() {
		return appframe;
	}

	public void setNotSearchedFalse() {
		if(notSearchedPanel.isVisible()) {
			notSearchedPanel.setVisible(false);
		} else {
			resultTabs.removeAll();
		}
	}
}
