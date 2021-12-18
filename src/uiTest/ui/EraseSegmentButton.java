package uiTest.ui;

import javax.swing.*;
import java.awt.event.*;
import uiTest.model.*;

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
		drawingApp.getDrawingAppModel().removeSelectedSegment() ;
	}
	
	public void notifyForUpdate() {
		Segment selected = drawingApp.getDrawingAppModel().getSelectedSegment();

		setEnabled(selected != null);
	}

}
