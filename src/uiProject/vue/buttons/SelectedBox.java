package uiProject.vue.buttons;

import java.awt.Graphics;

import javax.swing.JPanel;

import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

public class SelectedBox extends JPanel {
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;
	private String selectedBoxLabel;

	public SelectedBox(MazeApp mazeApp) {
		this.mazeApp = mazeApp;
		this.selectedBoxLabel = mazeApp.getMazeAppModel().getSelectedBoxLabel();
	}

	@Override
	protected final void paintComponent(Graphics g) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();

		super.paintComponent(g);

		int w = getWidth();
		int h = getHeight();

		this.selectedBoxLabel = mazeAppModel.getSelectedBoxLabel();

		int length = selectedBoxLabel.length();
		char[] data = new char[length];
		for (int i = 0; i < length; i++) {
			data[i] = selectedBoxLabel.charAt(i);
		}
		g.drawChars(data, 0, data.length, w / 3, h / 2);

	}

	public void notifyForUpdate() {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if (mazeAppModel.isModified()) {
			this.selectedBoxLabel = mazeAppModel.getSelectedBoxLabel();
			repaint();
		}
	}
}
