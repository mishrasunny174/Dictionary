package main;

import javax.swing.SwingUtilities;

import gui.GUIFrame;

public class DictionaryApp {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			GUIFrame app = new GUIFrame("Dictionary");
			app.init();
			app.run();
		});
	}

}
