package uiTest.ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class WindowPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final DrawingPanel drawingPanel;
	private final ButtonsPanel buttonsPanel;

	public WindowPanel(DrawingApp drawingApp) {
		setLayout(new BorderLayout());

		add(drawingPanel = new DrawingPanel(drawingApp), BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(drawingApp), BorderLayout.SOUTH);
	}

	public void notifyForUpdate() {
		drawingPanel.notifyForUpdate();
		buttonsPanel.notifyForUpdate();
	}

}