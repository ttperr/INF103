package uiTest.ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import uiTest.model.DrawingAppModel;

public class ColorChooserButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;

	public ColorChooserButton(DrawingApp drawingApp) {
		super("Choose color"); // Button's text
		this.drawingApp = drawingApp;

		addActionListener(this);
	}

	@Override
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
