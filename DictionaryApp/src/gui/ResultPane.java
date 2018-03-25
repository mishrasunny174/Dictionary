package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ResultPane {
	private JPanel resultPanel = null;
	private JLabel typeLabel = null;
	private JLabel definitionsLabel = null;
	private JLabel exampleLable = null;
	private JTextArea typeData = null;
	private JTextArea definitionData = null;
	private JTextArea exampleData = null;
	
	public ResultPane() {
		resultPanel = new JPanel();
		typeLabel = new JLabel("Type");
		definitionsLabel = new JLabel("Definition");
		exampleLable = new JLabel("Example");
		typeData = new JTextArea(2,25);
		definitionData = new JTextArea(2,25);
		exampleData = new JTextArea(2,25);
	}
	
	public JPanel getResultPane(String type,String definition,String example) {
		typeData.setText(type);
		typeData.setEditable(false);
		definitionData.setText(definition);
		definitionData.setEditable(false);
		exampleData.setText(example);
		exampleData.setEditable(false);
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 15);
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
		return resultPanel;
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
	
}
