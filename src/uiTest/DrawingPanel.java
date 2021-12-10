package uiTest;

import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JPanel {
	private final DrawingApp drawingApp;

	public DrawingPanel(DrawingApp drawingApp) {
		this.drawingApp = drawingApp;

		setBackground(Color.WHITE);

		// for pack() instruction
		setPreferredSize(new Dimension(300, 300));
	}
}