package uiProject.vue.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import uiProject.model.MazeAppModel;
import uiProject.vue.MazeApp;

/**
 * Import item menu class
 *
 *
 * @author Tristan Perrot
 *
 */
public class ImportMenuItem extends JMenuItem implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final MazeApp mazeApp;

	/**
	 * Create and add the import menu item in the mazeApp
	 *
	 * @param mazeApp The frame
	 */
	public ImportMenuItem(MazeApp mazeApp) {
		super("Import");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	/**
	 * Export the maze to text file when the button is clicked
	 */
	@Override
	public final void actionPerformed(ActionEvent event) {
		try {
			String filePath = null;
			MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
			JFileChooser jFileChooser = new JFileChooser("data/");
			jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
			jFileChooser.setAcceptAllFileFilterUsed(false);
			while (true) {
				int response = jFileChooser.showOpenDialog(mazeApp);
				if (response == JFileChooser.APPROVE_OPTION) {
					filePath = jFileChooser.getSelectedFile().getAbsolutePath();
					if (!filePath.endsWith(".txt")) {
						filePath = filePath + ".txt";
					}
					if (filePath.endsWith(".txt")) {
						break;
					}
				} else if (response == JFileChooser.CANCEL_OPTION) {
					int responseBis = JOptionPane.showInternalOptionDialog(this,
							"No maze where selected, do you want to select one ?", "No maze selected",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
					if (responseBis == JOptionPane.NO_OPTION) {
						break;
					}
				}
			}
			if (filePath != null) {
				mazeAppModel.initMazeFromTextFile(filePath);
			}
		} catch (Exception e) {
			JOptionPane.showInternalOptionDialog(this, e.getMessage(), "Error", JOptionPane.CANCEL_OPTION,
					JOptionPane.ERROR_MESSAGE, null, null, null);
		}
	}
}
