package uiProject.vue.maze;

import java.awt.event.*;

import algo.maze.*;
import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

public class BoxPanelMouseListener extends MouseAdapter implements MouseListener{
	MazeApp mazeApp;

	public BoxPanelMouseListener(MazeApp mazeApp) {
		super();
		this.mazeApp = mazeApp;
	}
	
	@Override
	public final void mouseReleased(MouseEvent e) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		String selectedBoxLabel = mazeAppModel.getSelectedBoxLabel();
		BoxPanel boxPanel = (BoxPanel) e.getSource();
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
	}
}
