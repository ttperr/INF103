package uiTest.ui;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final ColorIndicator colorIndicator;
	private final ColorChooserButton colorChooser;
	private final EraseSegmentButton eraseSegment;

	public ButtonsPanel(DrawingApp drawingApp) {
		setLayout(new GridLayout(1, 3)); // 1 row, 3 columns

		add(colorIndicator = new ColorIndicator(drawingApp));
		add(colorChooser = new ColorChooserButton(drawingApp));
		add(eraseSegment = new EraseSegmentButton(drawingApp));
	}

	public void notifyForUpdate() {
		colorIndicator.notifyForUpdate();
		eraseSegment.notifyForUpdate();
	}

}