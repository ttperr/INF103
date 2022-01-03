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
	
	public FileMenu(MazeApp mazeApp) {
		super("File");
		add(importMenuItem = new ImportMenuItem(mazeApp));
		add(exportMenuItem = new ExportMenuItem(mazeApp));
	}

}
