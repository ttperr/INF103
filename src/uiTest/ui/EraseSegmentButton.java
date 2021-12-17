package uiTest.ui;

import javax.swing.*;

import uiTest.model.*;

public class EraseSegmentButton extends JButton {
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp;

	public EraseSegmentButton(DrawingApp drawingApp) {
		super("Erase segment"); // Button's text

		this.drawingApp = drawingApp;
	}

	public void notifyForUpdate() {
		Segment selected = drawingApp.getDrawingAppModel().getSelectedSegment();

		setEnabled(selected != null);
	}

}
