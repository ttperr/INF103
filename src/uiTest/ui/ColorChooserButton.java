package uiTest.ui;

import javax.swing.*;

public class ColorChooserButton extends JButton {
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;

	public ColorChooserButton(DrawingApp drawingApp) {
		super("Choose color"); // Button's text

		this.drawingApp = drawingApp;
	}
}
