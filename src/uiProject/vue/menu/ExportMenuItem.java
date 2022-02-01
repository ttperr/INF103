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
public final class ExportMenuItem extends JMenuItem implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private final MazeApp mazeApp;

	/**
	 * Create and add the export menu item in the mazeApp
	 * 
	 * @param mazeApp The frame
	 */
	public ExportMenuItem(MazeApp mazeApp) {
		super("Export");
		this.mazeApp = mazeApp;
		addActionListener(this);
	}

	/**
	 * Export the maze to text file when the button is clicked
	 */
	public final void actionPerformed(ActionEvent e) {
		MazeAppModel mazeAppModel = mazeApp.getMazeAppModel();
		JFileChooser jFileChooser = new JFileChooser("data/");
		jFileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
		jFileChooser.setAcceptAllFileFilterUsed(false);
		int response = jFileChooser.showSaveDialog(mazeApp);
		if (response == JFileChooser.APPROVE_OPTION) {
			String filePath = jFileChooser.getSelectedFile().getAbsolutePath();
			if (!filePath.endsWith(".txt")) {
				filePath = filePath + ".txt";
			}
			mazeAppModel.exportMazeToTextFile(filePath);
			JOptionPane.showMessageDialog(mazeApp, "File exported !");
			mazeAppModel.setExported(true);
		}
	}
}