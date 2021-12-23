package uiProject.vue;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import uiProject.model.MazeAppModel;

/**
 * Maze App class
 * 
 * @author Tristan Perrot
 *
 */
public class MazeApp extends JFrame implements ChangeListener{
	private static final long serialVersionUID = 1L;
	private final MazeMenuBar mazeMenuBar;
	private final WindowPanel windowPanel;
	
	private MazeAppModel mazeAppModel = new MazeAppModel();
	
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

	/**
	 * @return the mazeAppModel
	 */
	public MazeAppModel getMazeAppModel() {
		return mazeAppModel;
	}
	/**
	 * Set the mazeAppModel
	 * 
	 * @param mazeAppModel The mazeAppModel to set
	 */
	public void setMazeAppModel(MazeAppModel mazeAppModel) {
		this.mazeAppModel = mazeAppModel;
	}

	@Override
	public void stateChanged(ChangeEvent evt) {
	   windowPanel.notifyForUpdate() ;	
	}

}
