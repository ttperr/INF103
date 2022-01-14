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
 * Quit item class in the menu
 * 
 * @author Tristan Perrot
 *
 */
public class QuitMenuItem extends JMenuItem implements ActionListener {
	private static final long serialVersionUID = 1L;
	private final MazeApp mazeApp;

	public QuitMenuItem(MazeApp mazeApp) {
		super("Quit");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	/**
	 * Quit the app when the button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();

		if (!mazeAppModel.isExported()) {
			int response = JOptionPane.showInternalOptionDialog(this, "Maze not saved. Export it ?",
					"Quit application", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null,
					null);
			if (response == JOptionPane.CANCEL_OPTION) {
				return;
			} else if (response == JOptionPane.OK_OPTION) {
				JFileChooser jFileChooser = new JFileChooser("data/");
				jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
				jFileChooser.setAcceptAllFileFilterUsed(false);
				int fileResponse = jFileChooser.showSaveDialog(mazeApp);
				if (fileResponse == JFileChooser.APPROVE_OPTION) {
					String filePath = jFileChooser.getSelectedFile().getAbsolutePath();
					if (!filePath.endsWith(".txt")) {
						filePath = filePath + ".txt";
					}
					mazeAppModel.exportMazeToTextFile(filePath);
					JOptionPane.showMessageDialog(mazeApp, "File exported !");
					mazeAppModel.setExported(true);
				}
			} else if (response == JOptionPane.NO_OPTION) {
			}
		}
		System.exit(0);
	}
}
