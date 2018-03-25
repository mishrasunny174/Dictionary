package testunits;

import javax.swing.SwingUtilities;

import gui.GUIFrame;

public class GUITest {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(()->{
			GUIFrame frame = new GUIFrame("Test");
			frame.init();
			frame.run();
		});
	}
}
