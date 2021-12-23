package uiProject.vue.maze;

import javax.swing.JPanel;

import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

import java.awt.*;

public class MazePanel extends JPanel {
	private final BoxPanel[][] boxes;
	private final MazeApp mazeApp;
	private final GridLayout gridLayout;
	
	public MazePanel(MazeApp mazeApp) {
		this.mazeApp = mazeApp;
		MazeAppModel drawingAppModel = mazeApp.getDrawingAppModel();
		int width = drawingAppModel.getMaze().getWidth();
		int height = drawingAppModel.getMaze().getHeight();
		this.gridLayout = new GridLayout(height,width,1,1);
		setLayout(gridLayout);
	}
}
