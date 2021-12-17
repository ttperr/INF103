package uiTest.ui;

import java.awt.*;
import javax.swing.*;

public class ColorIndicator extends JPanel {
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;

	public ColorIndicator(DrawingApp drawingApp) {
		this.drawingApp = drawingApp;
		setPreferredSize(new Dimension(100, 100));
	}

}