package uiProject.vue.buttons;

import javax.swing.JButton;

import algo.maze.DepartureArrivalException;
import uiProject.vue.MazeApp;
import java.awt.event.*;

public class SolveButton extends JButton implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;
	
	public SolveButton(MazeApp mazeApp) {
		super("Solve");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	public void actionPerformed(ActionEvent evt) {
		try {
			mazeApp.getMazeAppModel().solve();
		} catch (DepartureArrivalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
