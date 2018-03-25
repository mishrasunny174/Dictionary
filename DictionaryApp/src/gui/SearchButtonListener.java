package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dictionary.Data;
import dictionary.Dictionary;
import dictionary.Result;

public class SearchButtonListener implements ActionListener {
	
	private GUIFrame app = null;
	
	public SearchButtonListener(GUIFrame app) {
		this.app=app;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Data data = Dictionary.getData(app.getQuery());
		Result[] results = data.getResults();
		app.setDefinition(results[0].getDefinition());
		app.setType(results[0].getType());
		app.setExample(results[0].getExample());
	}
	

}
