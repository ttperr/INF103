package uiProject.vue.buttons;

import java.awt.GridLayout;

import javax.swing.JPanel;

import uiProject.vue.MazeApp;

/**
 * The buttons panel class
 * 
 * @author Tristan Perrot
 *
 */
public class ButtonsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private final DimensionPanel dimensionPanel;
	private final OptionPanel optionPanel;

	/**
	 * Create and add buttons in the mazeApp
	 * 
	 * @param mazeApp The frame
	 */
	public ButtonsPanel(MazeApp mazeApp) {
		setLayout(new GridLayout(1, 2));

		dimensionPanel = new DimensionPanel(mazeApp);
		optionPanel = new OptionPanel(mazeApp);

		add(dimensionPanel);
		add(optionPanel);
	}

	/**
	 * Notify when there is an update
	 */
	public final void notifyForUpdate() {
		optionPanel.notifyForUpdate();
	}
}
