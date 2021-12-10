package uiTest;

import java.awt.*;
import javax.swing.*;

public class ColorIndicator extends JPanel {
	private final DrawingApp drawingApp;

	public ColorIndicator(DrawingApp drawingApp) {
		this.drawingApp = drawingApp;
		setPreferredSize(new Dimension(100, 100));
	}

}