package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GUIFrame{
	private JFrame app = null;
	public GUIFrame(String title) {
		app = new JFrame(title);
	}
	
	public void init() {
		app.setSize(new Dimension(400, 400));
	}
	
	public void run() {
		app.setVisible(true);
	}

}
