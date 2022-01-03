package uiProject.vue.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

/**
 * Export item class in the menu
 * 
 * @author ttper
 *
 */
public class ExportMenuItem extends JMenuItem implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;

	public ExportMenuItem(MazeApp mazeApp) {
		super("Export");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	/**
	 * Export the maze to text file when the button is clicked
	 */
	public void actionPerformed(ActionEvent e) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		String fileName = JOptionPane.showInputDialog(mazeApp, "Text file name :");
		while (fileName.equals("")) {
			fileName = JOptionPane.showInputDialog(mazeApp, "File name cannot be empty ! Text file name :");
		}
		mazeAppModel.exportMazeToTextFile(fileName);
		JOptionPane.showMessageDialog(mazeApp, "File exported !");
		mazeAppModel.setExported(true);
	}
}
