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
			int response = JOptionPane.showInternalOptionDialog(mazeApp, "Maze not saved. Export it ?", "Quit application",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null);
			switch (response) {
			case JOptionPane.CANCEL_OPTION:
				return;
			case JOptionPane.OK_OPTION:
				JFileChooser jFileChooser = new JFileChooser("data/");
				jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
				int fileResponse = jFileChooser.showSaveDialog(mazeApp);
				if(fileResponse == JFileChooser.APPROVE_OPTION) {
					mazeAppModel.exportMazeToTextFile(jFileChooser.getSelectedFile().getAbsolutePath());
					JOptionPane.showMessageDialog(mazeApp, "File exported !");
					mazeAppModel.setExported(true);
				}
				break;
			case JOptionPane.NO_OPTION:
				break;
			}
		}
		System.exit(0);
	}
}
