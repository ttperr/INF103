package uiTest.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import uiTest.model.DrawingAppModel;

public class ColorChooserButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;

	public ColorChooserButton(DrawingApp drawingApp) {
		super("Choose color"); // Button's text
		this.drawingApp = drawingApp;

		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		// Used twice
		DrawingAppModel drawingAppModel = drawingApp.getDrawingAppModel();

		// Show JColorChooser dialog
		Color newColor = JColorChooser.showDialog(drawingApp, "Change segment color",
				drawingAppModel.getCurrentColor());
		// Changing color triggers refresh
		if (newColor != null)
			drawingAppModel.setCurrentColor(newColor);
	}

}
