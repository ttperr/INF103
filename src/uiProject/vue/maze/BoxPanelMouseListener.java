package uiProject.vue.maze;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import algo.maze.ABox;
import algo.maze.DBox;
import algo.maze.EBox;
import algo.maze.WBox;
import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

/**
 * Box panel mouse listener class
 * 
 * @author Tristan Perrot
 *
 */
public class BoxPanelMouseListener extends MouseAdapter implements MouseListener {
	MazeApp mazeApp;

	/**
	 * Create the mouse listener for the mazeApp
	 * 
	 * @param mazeApp The frame
	 */
	public BoxPanelMouseListener(MazeApp mazeApp) {
		super();
		this.mazeApp = mazeApp;
	}

	/**
	 * Action to do when mouse click is released
	 */
	@Override
	public final void mouseReleased(MouseEvent event) {
		try {
			MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
			String selectedBoxLabel = mazeAppModel.getSelectedBoxLabel();
			BoxPanel boxPanel = (BoxPanel) event.getSource();
			if (selectedBoxLabel.equals("Arrival")) {
				ABox box = new ABox(boxPanel.getBox().getRow(), boxPanel.getBox().getColumn());
				mazeAppModel.setBox(box);
			} else if (selectedBoxLabel.equals("Departure")) {
				DBox box = new DBox(boxPanel.getBox().getRow(), boxPanel.getBox().getColumn());
				mazeAppModel.setBox(box);
			} else if (selectedBoxLabel.equals("Empty")) {
				EBox box = new EBox(boxPanel.getBox().getRow(), boxPanel.getBox().getColumn());
				mazeAppModel.setBox(box);
			} else if (selectedBoxLabel.equals("Wall")) {
				WBox box = new WBox(boxPanel.getBox().getRow(), boxPanel.getBox().getColumn());
				mazeAppModel.setBox(box);
			}
		} catch (ClassCastException e) {
		}
	}
}
