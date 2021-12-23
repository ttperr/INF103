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
	
	public FileMenu(MazeApp mazeApp) {
		super("File");
		add(exportMenuItem = new ExportMenuItem(mazeApp));
	}

}
