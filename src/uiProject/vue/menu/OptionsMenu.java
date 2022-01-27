package uiProject.vue.menu;

import javax.swing.JMenu;

import uiProject.vue.MazeApp;

/**
 * Options menu class
 * 
 * @author Tristan Perrot
 *
 */
public class OptionsMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private final QuitMenuItem quitMenuItem;
	private final ResetMenuItem resetMenuItem;

	/**
	 * Create and add the options menu items in the mazeApp
	 * 
	 * @param mazeApp The frame
	 */
	public OptionsMenu(MazeApp mazeApp) {
		super("Options");
		add(resetMenuItem = new ResetMenuItem(mazeApp));
		add(quitMenuItem = new QuitMenuItem(mazeApp));
	}
}
