package uiProject.vue.maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import algo.maze.MBox;
import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

/**
 * Maze panel class
 * 
 * @author Tristan Perrot
 *
 */
public class MazePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private BoxPanel[][] boxes;
	private final MazeApp mazeApp;
	private final GridLayout gridLayout;

	public MazePanel(MazeApp mazeApp) {
		this.mazeApp = mazeApp;
		MazeAppModel MazeAppModel = mazeApp.getMazeAppModel();
		int width = MazeAppModel.getMaze().getWidth();
		int height = MazeAppModel.getMaze().getHeight();
		this.gridLayout = new GridLayout(height, width, 2, 2);
		setLayout(gridLayout);
		setPreferredSize(new Dimension(900, 600));
		setBackground(Color.BLACK);

		boxes = new BoxPanel[height][width];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				BoxPanel boxPanel = new BoxPanel(mazeApp, MazeAppModel.getMaze().getBox(i, j));
				boxes[i][j] = boxPanel;
				add(boxPanel);
			}
		}
		BoxPanelMouseListener mazePanelMouseListener = new BoxPanelMouseListener(mazeApp);
		addMouseListener(mazePanelMouseListener);
	}

	/**
	 * @return the boxes
	 */
	public BoxPanel[][] getBoxes() {
		return boxes;
	}

	/**
	 * fill the grid layout with the maze of MazeApp
	 */
	public void fillGrid() {
		this.removeAll();
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		MBox[][] mazeModel = mazeAppModel.getMaze().getMaze();
		BoxPanel[][] boxes = new BoxPanel[mazeAppModel.getMaze().getHeight()][mazeAppModel.getMaze().getWidth()];
		for (int row = 0; row < gridLayout.getRows(); row++) {
			for (int col = 0; col < gridLayout.getColumns(); col++) {
				BoxPanel boxPanel = new BoxPanel(mazeApp, mazeModel[row][col]);
				boxes[row][col] = boxPanel;
				this.add(boxPanel);
			}
		}
		revalidate();
		repaint();
	}

	/**
	 * Action to do if there is an update of the maze
	 */
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
