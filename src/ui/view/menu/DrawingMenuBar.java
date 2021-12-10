package ui.view.menu;

import javax.swing.*;

import ui.view.DrawingApp;

public class DrawingMenuBar extends JMenuBar {

	private final FileMenu fileMenu ;
	
	public DrawingMenuBar(DrawingApp drawingApp)
	{
		super() ;
		
		// Create and add menus
		add(fileMenu = new FileMenu(drawingApp)) ;
	}
}
