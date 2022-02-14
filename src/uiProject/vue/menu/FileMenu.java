package uiProject.vue.menu;

import javax.swing.JMenu;

import uiProject.vue.MazeApp;

/**
 * File menu class
 *
 * @author Tristan Perrot
 *
 */
public class FileMenu extends JMenu {
	private static final long serialVersionUID = 1L;

	private final ExportMenuItem exportMenuItem;
	private final ImportMenuItem importMenuItem;

	/**
	 * Create and add menu items to mazeApp
	 *
	 * @param mazeApp The current used app
	 */
	public FileMenu(MazeApp mazeApp) {
		super("File");

		importMenuItem = new ImportMenuItem(mazeApp);
		exportMenuItem = new ExportMenuItem(mazeApp);

		add(importMenuItem);
		add(exportMenuItem);
	}

}
