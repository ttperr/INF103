package ui.view.menu.item;

import javax.swing.*;

import ui.view.DrawingApp;

public class QuitMenuItem extends JMenuItem {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingApp drawingApp ;

   public QuitMenuItem(DrawingApp drawingApp)
   {
      super("Quit") ; // Text of menu item

      this.drawingApp = drawingApp ;
   }

}