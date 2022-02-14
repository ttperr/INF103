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

		eTypeButton = new TypeBoxButton(mazeApp, "Empty");
		wTypeButton = new TypeBoxButton(mazeApp, "Wall");
		aTypeButton = new TypeBoxButton(mazeApp, "Arrival");
		dTypeButton = new TypeBoxButton(mazeApp, "Departure");

		add(eTypeButton);
		add(wTypeButton);
		add(aTypeButton);
		add(dTypeButton);
	}
}
