package uiProject.vue.buttons;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import uiProject.vue.MazeApp;

public class DimensionPanel extends JPanel {
	private final DimensionSet dimensionSet;

	public DimensionPanel(MazeApp mazeApp) {
		setLayout(new BorderLayout());
		add(dimensionSet = new DimensionSet(mazeApp), BorderLayout.CENTER);
	}
}
