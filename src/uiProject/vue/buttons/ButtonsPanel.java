package uiProject.vue.buttons;

import java.awt.GridLayout;

import javax.swing.JPanel;

import uiProject.vue.MazeApp;

public class ButtonsPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final DimensionPanel dimensionPanel;
	private final OptionPanel optionPanel;

	public ButtonsPanel(MazeApp mazeApp) {
		setLayout(new GridLayout(1, 2));
		add(dimensionPanel = new DimensionPanel(mazeApp));
		add(optionPanel = new OptionPanel(mazeApp));
	}

	public void notifyForUpdate() {
		dimensionPanel.notifyForUpdate();
		optionPanel.notifyForUpdate();
	}
}
