package ui.view;

import javax.swing.* ;

import ui.view.menu.DrawingMenuBar;

public class DrawingApp extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final DrawingMenuBar drawingMenuBar;

	public DrawingApp()
	   {
	      super("Drawing Application") ; // Window title

	    
		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this)) ;

	      // Window content creation
	   
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ; // Explicit !

	      pack() ;            // Components sizes and positions
	      setVisible(true) ;  // The great show
	   }

}
