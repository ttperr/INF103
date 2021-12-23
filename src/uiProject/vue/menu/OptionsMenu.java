package uiProject.vue.menu;

import javax.swing.JMenu;

import uiProject.vue.MazeApp;

public class OptionsMenu extends JMenu {
	private static final long serialVersionUID = 1L;
	private final QuitMenuItem quitMenuItem;
	private final ResetMenuItem resetMenuItem;

	public OptionsMenu(MazeApp mazeApp) {
		super("Options");
		add(quitMenuItem = new QuitMenuItem(mazeApp));
		add(resetMenuItem = new ResetMenuItem(mazeApp));
	}
}
