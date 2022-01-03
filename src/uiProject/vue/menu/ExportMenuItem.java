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
 * Export item class in the menu
 * 
 * @author Tristan Perrot
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
		JFileChooser jFileChooser = new JFileChooser("data/");
		jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
		int response = jFileChooser.showSaveDialog(mazeApp);
		if (response == JFileChooser.APPROVE_OPTION) {
			mazeAppModel.exportMazeToTextFile(jFileChooser.getSelectedFile().getAbsolutePath());
			JOptionPane.showMessageDialog(mazeApp, "File exported !");
			mazeAppModel.setExported(true);
		}
	}
}