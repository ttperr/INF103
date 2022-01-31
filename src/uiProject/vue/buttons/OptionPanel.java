package uiProject.vue.buttons;

import java.awt.GridLayout;

import javax.swing.JPanel;

import uiProject.vue.MazeApp;

/**
 * The option panel class
 * 
 * @author Tristan Perrot
 *
 */
public class OptionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final SelectedBox selectedBox;
	private final SolveButton solveButton;

	/**
	 * Create and add the option buttons in the mazeApp
	 * 
	 * @param mazeApp The frame
	 */
	public OptionPanel(MazeApp mazeApp) {
		setLayout(new GridLayout(2, 1));

		selectedBox = new SelectedBox(mazeApp);
		solveButton = new SolveButton(mazeApp);

		add(selectedBox);
		add(solveButton);
	}

	/**
	 * Notify when there is an update
	 */
	public void notifyForUpdate() {
		selectedBox.notifyForUpdate();
	}
}
