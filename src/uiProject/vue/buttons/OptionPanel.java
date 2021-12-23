package uiProject.vue.buttons;

import java.awt.GridLayout;

import javax.swing.JPanel;

import uiProject.vue.MazeApp;

public class OptionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final SelectedBox selectedBox;
	private final SolveButton solveButton;

	public OptionPanel(MazeApp mazeApp) {
		setLayout(new GridLayout(2, 1));
		add(selectedBox = new SelectedBox(mazeApp));
		add(solveButton = new SolveButton(mazeApp));
	}

	public void notifyForUpdate() {
		selectedBox.notifyForUpdate();
	}
}
