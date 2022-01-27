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
public class MazeApp extends JFrame implements ChangeListener {
	private static final long serialVersionUID = 1L;
	private final MazeMenuBar mazeMenuBar;
	private final WindowPanel windowPanel;

	private MazeAppModel mazeAppModel = new MazeAppModel();
	
	/**
	 * Create and add a menu bar and the content main pane
	 */
	public MazeApp() {
		super("Solveur de labyrinthe");

		setJMenuBar(mazeMenuBar = new MazeMenuBar(this));
		setContentPane(windowPanel = new WindowPanel(this));

		mazeAppModel.addObserver(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

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
	
	/**
	 * Notify when there is an update
	 */
	@Override
	public void stateChanged(ChangeEvent evt) {
		windowPanel.notifyForUpdate();
	}

}
