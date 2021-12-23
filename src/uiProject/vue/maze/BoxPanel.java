package uiProject.vue.maze;

import javax.swing.JPanel;

import algo.maze.MBox;
import uiProject.vue.MazeApp;

public class BoxPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final MBox box;
	private BoxPanelMouseListener mazePanelMouseListener;

	public BoxPanel(MazeApp mazeApp, MBox box) {
		this.box = box;
		mazePanelMouseListener = new BoxPanelMouseListener(mazeApp);
		addMouseListener(mazePanelMouseListener);
	}

	/**
	 * @return the box
	 */
	public MBox getBox() {
		return box;
	}

	public void notifyForUpdate() {
		repaint();
	}
}
