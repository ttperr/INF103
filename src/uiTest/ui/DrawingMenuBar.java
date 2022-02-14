package uiTest.ui;

import javax.swing.JMenuBar;

public class DrawingMenuBar extends JMenuBar {
	private static final long serialVersionUID = 1L;
	private final FileMenu fileMenu;

	public DrawingMenuBar(DrawingApp drawingApp) {
		super();

		// Create and add menus
		add(fileMenu = new FileMenu(drawingApp));
	}
}
