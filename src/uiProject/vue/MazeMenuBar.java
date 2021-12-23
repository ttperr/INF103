package uiProject.vue;

import javax.swing.JMenuBar;

import uiProject.vue.menu.*;

public class MazeMenuBar extends JMenuBar{
	private static final long serialVersionUID = 1L;
	private final FileMenu fileMenu;
	private final OptionsMenu optionsMenu;

	public MazeMenuBar(MazeApp MazeApp) {
		super();

		// Create and add menus
		add(fileMenu = new FileMenu(MazeApp));
		add(optionsMenu = new OptionsMenu(MazeApp));
	}
}
