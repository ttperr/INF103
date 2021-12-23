package uiProject.vue;

import javax.swing.*;
import javax.swing.event.*;

import uiProject.model.*;

public class MazeApp extends JFrame implements ChangeListener{
	private static final long serialVersionUID = 1L;
	private final MazeMenuBar mazeMenuBar;
	private final WindowPanel windowPanel;

	public MazeApp() {
		super("Solveur de labyrinthe"); // Window title

		setJMenuBar(mazeMenuBar = new MazeMenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));

		drawingAppModel.addObserver(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Explicit !
		pack(); // Components sizes and positions
		setVisible(true); // The great show

	}

	private MazeAppModel drawingAppModel = new MazeAppModel();

	public MazeAppModel getDrawingAppModel() {
		return drawingAppModel;
	}

	public void setDrawingAppModel(MazeAppModel drawingAppModel) {
		this.drawingAppModel = drawingAppModel;
	}

	@Override
	public void stateChanged(ChangeEvent evt) {
	   windowPanel.notifyForUpdate() ;	
	}

}
