package uiProject.vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import uiProject.vue.buttons.ButtonsPanel;
import uiProject.vue.maze.MazePanel;
import uiProject.vue.selectBox.SelectBoxPanel;

public class WindowPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final MazePanel MazePanel;
	private final ButtonsPanel buttonsPanel;
	private final SelectBoxPanel selectBoxPanel;

	public WindowPanel(MazeApp drawingApp) {
		setLayout(new BorderLayout());

		add(MazePanel = new MazePanel(drawingApp), BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(drawingApp), BorderLayout.SOUTH);
		add(selectBoxPanel = new SelectBoxPanel(drawingApp), BorderLayout.EAST);
	}

	public void notifyForUpdate() {
		MazePanel.notifyForUpdate();
		buttonsPanel.notifyForUpdate();
	}
}