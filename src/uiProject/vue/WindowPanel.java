package uiProject.vue;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import uiProject.vue.buttons.ButtonsPanel;
import uiProject.vue.maze.MazePanel;
import uiProject.vue.selectBox.SelectBoxPanel;

/**
 * The window panel class
 * 
 * @author Tristan Perrot
 *
 */
public class WindowPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final MazePanel MazePanel;
	private final ButtonsPanel buttonsPanel;
	private final SelectBoxPanel selectBoxPanel;

	/**
	 * Create and add everything to the main frame
	 */
	public WindowPanel(MazeApp drawingApp) {
		setLayout(new BorderLayout());

		MazePanel = new MazePanel(drawingApp);
		buttonsPanel = new ButtonsPanel(drawingApp);
		selectBoxPanel = new SelectBoxPanel(drawingApp);

		add(MazePanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
		add(selectBoxPanel, BorderLayout.EAST);
	}

	/**
	 * Notify when there is an update
	 */
	public void notifyForUpdate() {
		MazePanel.notifyForUpdate();
		buttonsPanel.notifyForUpdate();
	}
}
