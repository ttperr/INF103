package uiTest;

import javax.swing.*;

public class DrawingApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private final DrawingMenuBar drawingMenuBar;
	private final WindowPanel windowPanel;

	public DrawingApp() {
		super("Drawing Application"); // Window title

		setJMenuBar(drawingMenuBar = new DrawingMenuBar(this));

		setContentPane(windowPanel = new WindowPanel(this)) ;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Explicit !
		pack(); // Components sizes and positions
		setVisible(true); // The great show
	}

}
