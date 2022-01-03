package uiProject.vue.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

public class ImportMenuItem extends JMenuItem implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;

	public ImportMenuItem(MazeApp mazeApp) {
		super("Import");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	/**
	 * Export the maze to text file when the button is clicked
	 */
	public void actionPerformed(ActionEvent event) {
		ArrayList<String> arraySelection = new ArrayList<>();
		File data = new File("data");
		for (File file : data.listFiles()) {
			if (file.isFile() && file.getName().substring(file.getName().length() - 4).equals(".txt")) {
				arraySelection.add(file.getName());
			}
		}
		arraySelection.add("Other...");
		Object[] selection = arraySelection.toArray();

		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		while (true) {
			String fileName = (String) JOptionPane.showInputDialog(mazeApp, "Choose a text file finded in data folders",
					"Import a maze", JOptionPane.QUESTION_MESSAGE, null, selection, selection[0]);
			if (fileName == "Other...") {
				fileName = JOptionPane.showInputDialog(this, "Path to the file :",
						"C:/Users/ttper/Documents/eclipse-workspace/perrot-tristan/data/labyrinthe.txt");
				while (fileName == "") {
					fileName = JOptionPane.showInputDialog(this, "File name cannot be empty ! Path to the file :",
							"C:/Users/ttper/Documents/eclipse-workspace/perrot-tristan/data/labyrinthe.txt");
				}
			} else if (fileName != null) {
				fileName = "data/" + fileName;
			}
			try {
				if (fileName != null) {
					mazeAppModel.initMazeFromTextFile(fileName);
					break;
				} else {
					int response = JOptionPane.showConfirmDialog(null, "0 file selected, do you still want to import a maze ?", "No file selected",
					        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.NO_OPTION || response == JOptionPane.CLOSED_OPTION) {
					      break;
					    }
				}
			} catch (Exception e) {
				JOptionPane.showInternalOptionDialog(this, e.getMessage(), "Error", JOptionPane.CANCEL_OPTION,
						JOptionPane.ERROR_MESSAGE, null, null, null);
			}
		}
	}
}
