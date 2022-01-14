package uiProject.vue.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
		try {
			String filePath = null;
			while (true) {
				MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
				JFileChooser jFileChooser = new JFileChooser("data/");
				jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
				int response = jFileChooser.showOpenDialog(mazeApp);
				if (response == JFileChooser.APPROVE_OPTION) {
					filePath = jFileChooser.getSelectedFile().getAbsolutePath();
					if (!filePath.endsWith(".txt")) {
						filePath = filePath + ".txt";
					}
					if(filePath.endsWith(".txt")) {break;}
				}
				mazeAppModel.initMazeFromTextFile(filePath);
			}
		} catch (Exception e) {
			JOptionPane.showInternalOptionDialog(this, e.getMessage(), "Error", JOptionPane.CANCEL_OPTION,
					JOptionPane.ERROR_MESSAGE, null, null, null);
		}
	}
}
