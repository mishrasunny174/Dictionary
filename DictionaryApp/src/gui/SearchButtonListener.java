package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import dictionary.Data;
import dictionary.Dictionary;
import dictionary.NotFoundException;
import dictionary.Result;
import dictionary.UnableToConnectException;

public class SearchButtonListener implements ActionListener {

	private GUIFrame app = null;

	public SearchButtonListener(GUIFrame app) {
		this.app = app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Data data;
		JTabbedPane tabs = app.getResultsTabbedPane();
		if (!app.getQuery().equals("")) {
			try {
				if(app.getQuery().contains(" "))
					throw new NotFoundException("Cant find");
				app.setNotSearchedFalse();
				tabs.setVisible(true);
				data = Dictionary.getData(app.getQuery());
				Result[] results = data.getResults();
				int counter = 1;
				for(Result result : results) {
					tabs.add("result "+counter,new ResultPane().getResultPane(result.getType(),result.getDefinition(),result.getExample()));
					counter++;
				}
			} catch (UnableToConnectException e) {
				JDialog errorDialogue = new JDialog(app.getFrame(), "ERROR", true);
				errorDialogue.setLayout(new GridLayout(2,1));
				errorDialogue.setSize(new Dimension(400, 150));
				JPanel errorPanel = new JPanel();
				JLabel error = new JLabel("Unable to connect to API".toUpperCase());
				error.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
				error.setForeground(Color.RED);
				errorPanel.add(error);
				errorDialogue.add(errorPanel);
				JPanel buttonPanel = new JPanel();
				JButton okay = new JButton("Okay");
				okay.addActionListener((okayEvent) -> {
					errorDialogue.setVisible(false);
				});
				buttonPanel.add(okay);
				errorDialogue.add(buttonPanel);
				errorDialogue.setVisible(true);
			} catch (IOException e) {
				System.err.println("[DEBUG] error while parsing json");
			} catch (NotFoundException e) {
				JDialog dialog = new JDialog(app.getFrame(), "ERROR", true);
				dialog.setSize(new Dimension(400, 150));
				dialog.setLayout(new GridLayout(2, 1));
				JLabel error = new JLabel("NOT AVAILABLE!!!");
				error.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
				JPanel panel = new JPanel();
				panel.add(error);
				dialog.add(panel);
				JPanel buttonPanel = new JPanel();
				JButton okay = new JButton("Okay");
				okay.addActionListener((okayAction) -> {
					dialog.setVisible(false);
				});
				buttonPanel.add(okay);
				dialog.add(buttonPanel);
				dialog.setVisible(true);
			}
		} else {
			JDialog dialog = new JDialog(app.getFrame(), "ERROR", true);
			dialog.setSize(new Dimension(400, 150));
			dialog.setLayout(new GridLayout(2, 1));
			JLabel error = new JLabel("Please enter a word to search for!");
			error.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			JPanel panel = new JPanel();
			panel.add(error);
			dialog.add(panel);
			JPanel buttonPanel = new JPanel();
			JButton okay = new JButton("Okay");
			okay.addActionListener((okayAction) -> {
				dialog.setVisible(false);
			});
			buttonPanel.add(okay);
			dialog.add(buttonPanel);
			dialog.setVisible(true);
		}

	}

}
