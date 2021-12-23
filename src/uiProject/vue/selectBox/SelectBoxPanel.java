package uiProject.vue.selectBox;

import java.awt.GridLayout;

import javax.swing.JPanel;

import uiProject.vue.MazeApp;

public class SelectBoxPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final TypeBoxButton eTypeButton;
	private final TypeBoxButton wTypeButton;
	private final TypeBoxButton aTypeButton;
	private final TypeBoxButton dTypeButton;

	public SelectBoxPanel(MazeApp mazeApp) {
		setLayout(new GridLayout(4, 1));
		add(eTypeButton = new TypeBoxButton(mazeApp, "Empty"));
		add(wTypeButton = new TypeBoxButton(mazeApp, "Wall"));
		add(aTypeButton = new TypeBoxButton(mazeApp, "Arrival"));
		add(dTypeButton = new TypeBoxButton(mazeApp, "Departure"));
	}
}
