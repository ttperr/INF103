package uiProject.vue.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import uiProject.vue.MazeApp;

/**
 * Reset item class in the menu
 * 
 * @author ttper
 *
 */
public class ResetMenuItem extends JMenuItem implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;

	public ResetMenuItem(MazeApp mazeApp) {
		super("Reset");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	/**
	 * Reset the maze when button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		mazeApp.getMazeAppModel().reset(10, 10);
	}
}
