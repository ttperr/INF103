package uiProject.vue.menu;

import javax.swing.JMenu;

import uiProject.vue.MazeApp;

/**
 * Options menu class
 * 
 * @author Tristan Perrot
 *
 */
public final class OptionsMenu extends JMenu {
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

		resetMenuItem = new ResetMenuItem(mazeApp);
		quitMenuItem = new QuitMenuItem(mazeApp);

		add(resetMenuItem);
		add(quitMenuItem);
	}
}
