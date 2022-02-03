package uiProject.vue.buttons;

import java.awt.Graphics;

import javax.swing.JPanel;

import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

/**
 * The selected box class
 * 
 * @author Tristan Perrot
 *
 */
public class SelectedBox extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;
	private String selectedBoxLabel;

	public SelectedBox(MazeApp mazeApp) {
		this.mazeApp = mazeApp;
		this.selectedBoxLabel = mazeApp.getMazeAppModel().getSelectedBoxLabel();
	}

	/**
	 * Show the current box selected
	 */
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

	/**
	 * Action to do if there is an update of the box
	 */
	public final void notifyForUpdate() {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if (mazeAppModel.isModified()) {
			this.selectedBoxLabel = mazeAppModel.getSelectedBoxLabel();
			repaint();
		}
	}
}
