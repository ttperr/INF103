package uiProject.vue;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
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
		super("Maze solver");

		mazeMenuBar = new MazeMenuBar(this);
		windowPanel = new WindowPanel(this);

		setJMenuBar(mazeMenuBar);
		setContentPane(windowPanel);

		mazeAppModel.addObserver(this);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("data/icon.png");  
	    setIconImage(icon);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	/**
	 * @return the mazeAppModel
	 */
	public final MazeAppModel getMazeAppModel() {
		return mazeAppModel;
	}

	/**
	 * Set the mazeAppModel
	 *
	 * @param mazeAppModel The mazeAppModel to set
	 */
	public final void setMazeAppModel(MazeAppModel mazeAppModel) {
		this.mazeAppModel = mazeAppModel;
	}

	/**
	 * Notify when there is an update
	 */
	@Override
	public final void stateChanged(ChangeEvent evt) {
		windowPanel.notifyForUpdate();
	}

}
