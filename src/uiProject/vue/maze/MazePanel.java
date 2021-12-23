package uiProject.vue.maze;

import javax.swing.JPanel;
import java.awt.*;

import algo.maze.MBox;
import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

public class MazePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final BoxPanel[][] boxes;
	private final MazeApp mazeApp;
	private final GridLayout gridLayout;

	public MazePanel(MazeApp mazeApp) {
		this.mazeApp = mazeApp;
		MazeAppModel MazeAppModel = mazeApp.getMazeAppModel();
		int width = MazeAppModel.getMaze().getWidth();
		int height = MazeAppModel.getMaze().getHeight();
		this.gridLayout = new GridLayout(height, width, 2, 2);
		setLayout(gridLayout);
		setPreferredSize(new Dimension(300, 300));
		setBackground(Color.WHITE);

		boxes = new BoxPanel[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				BoxPanel boxPanel = new BoxPanel(mazeApp, MazeAppModel.getMaze().getBox(i, j));
				boxes[i][j] = boxPanel;
				add(boxPanel);
			}
		}
	}

	/**
	 * @return the boxes
	 */
	public BoxPanel[][] getBoxes() {
		return boxes;
	}

	public void fillGrid() {
		this.removeAll();
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		MBox[][] mazeModel = mazeAppModel.getMaze().getMaze();
		for (int row = 0; row < gridLayout.getRows(); row++) {
			for (int col = 0; col < gridLayout.getColumns(); col++) {
				BoxPanel boxPanel = new BoxPanel(mazeApp, mazeModel[row][col]);
				this.add(boxPanel);
			}
		}
		revalidate();
		repaint();
	}

	public void notifyForUpdate() {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		if (mazeAppModel.isModified()) {
			int width = mazeAppModel.getMaze().getWidth();
			int height = mazeAppModel.getMaze().getHeight();
			gridLayout.setColumns(width);
			gridLayout.setRows(height);
			fillGrid();
		}
	}

}
