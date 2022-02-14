package uiTest.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import uiTest.model.Segment;

public class EraseSegmentButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;

	public EraseSegmentButton(DrawingApp drawingApp) {
		super("Erase segment"); // Button's text
		this.drawingApp = drawingApp;

		addActionListener(this);
	}

	public final void actionPerformed(ActionEvent evt) {
		// Operation delegated to the model
		drawingApp.getDrawingAppModel().removeSelectedSegment();
	}

	public void notifyForUpdate() {
		Segment selected = drawingApp.getDrawingAppModel().getSelectedSegment();

		setEnabled(selected != null);
	}

}
