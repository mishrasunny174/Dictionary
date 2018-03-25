package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
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
	private JPanel resultPanel = null;
	private JLabel typeLabel = null;
	private JLabel definitionsLabel = null;
	private JLabel exampleLable = null;
	private JTextArea typeData = null;
	private JTextArea definitionData = null;
	private JTextArea exampleData = null;
	private JPanel resultHeaderPanel = null;
	private JLabel resultHeader = null;
	private JFrame appframe = null;
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
		resultPanel = new JPanel();
		typeLabel = new JLabel("Type");
		definitionsLabel = new JLabel("Definition");
		exampleLable = new JLabel("Example");
		typeData = new JTextArea(2,25);
		definitionData = new JTextArea(2,25);
		exampleData = new JTextArea(2,25);
		resultHeaderPanel = new JPanel();
		resultHeader = new JLabel("Result");
	}

	public void init() {
		appframe.setSize(new Dimension(400, 300));
		appframe.add(app);
		appframe.setLayout(new GridLayout(1,1));
		appframe.setResizable(true);
		appframe.setBackground(Color.WHITE);
		appframe.setMinimumSize(new Dimension(400, 300));
		app.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.weighty=0.5;
		Font mainFont = new Font(Font.SANS_SERIF, Font.BOLD, 30);
		mainLabel.setFont(mainFont);
		mainLabel.setForeground(Color.red);
		mainLabelPanel.add(mainLabel);
		mainLabelPanel.setAlignmentY(SwingConstants.CENTER);
		app.add(mainLabelPanel,gbc);
		gbc.gridy=1;
		gbc.weighty=0;
		app.add(new JSeparator(SwingConstants.HORIZONTAL),gbc);
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
		searchLabel.setFont(font);
		searchButton.addActionListener(new SearchButtonListener(this));
		searchPanel.add(searchLabel);
		searchPanel.add(new JSeparator(SwingConstants.VERTICAL));
		searchField.setFont(font);
		searchField.setText("");
		searchPanel.add(searchField);
		searchPanel.add(searchButton);
		gbc.gridx=0;
		gbc.gridy=2;
		gbc.weighty=0;
		gbc.fill=GridBagConstraints.HORIZONTAL;
		app.add(searchPanel,gbc);
		gbc.gridy=3;
		app.add(new JSeparator(SwingConstants.HORIZONTAL),gbc);
		gbc.gridy=4;
		gbc.weighty=0;
		resultHeader.setFont(mainFont);
		resultHeader.setForeground(Color.BLACK);
		resultHeaderPanel.add(resultHeader);
		app.add(resultHeaderPanel,gbc);
		resultPanel.setLayout(new GridBagLayout());
		GridBagConstraints gbcResult = new GridBagConstraints();
		gbcResult.weighty=1;
		gbcResult.gridx=0;
		gbcResult.gridy=0;
		gbcResult.weightx=0.5;
		gbcResult.gridheight=2;
		typeLabel.setFont(font);
		resultPanel.add(typeLabel,gbcResult);
		definitionsLabel.setFont(font);
		gbcResult.gridy=3;
		resultPanel.add(definitionsLabel,gbcResult);
		exampleLable.setFont(font);
		gbcResult.gridy=6;
		resultPanel.add(exampleLable,gbcResult);
		gbcResult.gridx=1;
		gbcResult.gridy=0;
		gbcResult.fill=GridBagConstraints.VERTICAL;
		gbcResult.gridheight=8;
		resultPanel.add(new JSeparator(SwingConstants.VERTICAL),gbcResult);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbcResult.gridx=2;
		gbcResult.gridy=0;
		gbcResult.weightx=1;
		gbcResult.gridheight=2;
		typeData.setLineWrap(true);
		typeData.setWrapStyleWord(true);
		resultPanel.add(typeData,gbcResult);
		gbcResult.gridy=3;
		definitionData.setLineWrap(true);
		definitionData.setWrapStyleWord(true);
		resultPanel.add(definitionData,gbcResult);
		gbcResult.gridy=6;
		exampleData.setLineWrap(true);
		exampleData.setWrapStyleWord(true);
		GridBagConstraints spaceGbc = new GridBagConstraints();
		spaceGbc.gridy=2;
		spaceGbc.gridx=0;
		spaceGbc.gridwidth=3;
		spaceGbc.fill=GridBagConstraints.HORIZONTAL;
		resultPanel.add(new JSeparator(SwingConstants.HORIZONTAL),spaceGbc);
		spaceGbc.gridy=5;
		resultPanel.add(new JSeparator(SwingConstants.HORIZONTAL),spaceGbc);
		resultPanel.add(exampleData,gbcResult);
		resultPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		gbc.gridx=0;
		gbc.gridy=5;
		gbc.weighty=1;
		app.add(resultPanel,gbc);
	}

	public void run() {
		appframe.setVisible(true);
	}

	public String getQuery() {
		return searchField.getText();
	}
	
	public void setType(String type) {
		typeData.setText(type);
	}

	public void setDefinition(String definition) {
		definitionData.setText(definition);
	}
	
	public void setExample(String example) {
		exampleData.setText(example);
	}
	
	public JFrame getFrame() {
		return appframe;
	}
}
