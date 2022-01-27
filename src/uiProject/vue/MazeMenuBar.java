package uiProject.vue;

import javax.swing.JMenuBar;

import uiProject.vue.menu.*;

/**
 * Menu bar class of the MazeApp
 * 
 * @author Tristan Perrot
 *
 */
public class MazeMenuBar extends JMenuBar{
	private static final long serialVersionUID = 1L;
	private final FileMenu fileMenu;
	private final OptionsMenu optionsMenu;

	/**
	 * Create and add menu in MazeApp
	 * 
	 * @param MazeApp The frame
	 */
	public MazeMenuBar(MazeApp MazeApp) {
		super();

		// Create and add menus
		add(fileMenu = new FileMenu(MazeApp));
		add(optionsMenu = new OptionsMenu(MazeApp));
	}
}
