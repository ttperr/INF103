package ui.view.menu;

import javax.swing.*;

import ui.view.DrawingApp;
import ui.view.menu.item.QuitMenuItem;

public class FileMenu extends JMenu {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final QuitMenuItem quitMenuItem ;

   public FileMenu(DrawingApp drawingApp)
   {
      super("File") ; // Text of the menu

      // Create and add menu items
      
      add(quitMenuItem = new QuitMenuItem(drawingApp)) ;
   }
}