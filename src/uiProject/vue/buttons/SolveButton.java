package uiProject.vue.buttons;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import algo.maze.DepartureArrivalException;
import algo.maze.NoPathException;
import uiProject.vue.MazeApp;
import java.awt.event.*;

/**
 * The solve button class
 * 
 * @author Tristan Perrot
 *
 */
public class SolveButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final MazeApp mazeApp;

	/**
	 * Create and add button in the mazeApp
	 * 
	 * @param mazeApp The frame
	 */
	public SolveButton(MazeApp mazeApp) {
		super("Solve");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	/**
	 * Solve the maze when it's clicked
	 */
	public final void actionPerformed(ActionEvent evt) {
		try {
			mazeApp.getMazeAppModel().solve();
		} catch (DepartureArrivalException | NoPathException e) {
			JOptionPane.showInternalOptionDialog(null, e.getMessage(), "Error", JOptionPane.CANCEL_OPTION,
					JOptionPane.ERROR_MESSAGE, null, null, null);
		}
	}

}
