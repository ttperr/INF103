package uiProject.vue.buttons;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import uiProject.vue.MazeApp;

/**
 * The dimension panel class
 * 
 * @author Tristan Perrot
 *
 */
public class DimensionPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private final DimensionSet dimensionSet;

	/**
	 * Create and add the dimension buttons in the mazeApp
	 * 
	 * @param mazeApp The frame
	 */
	public DimensionPanel(MazeApp mazeApp) {
		setLayout(new BorderLayout());

		dimensionSet = new DimensionSet(mazeApp);

		add(dimensionSet, BorderLayout.CENTER);
	}
}
