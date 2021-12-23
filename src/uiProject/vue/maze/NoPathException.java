package uiProject.vue.maze;

import javax.swing.JOptionPane;

/**
 * Exception when there is no maze solution (throw a pop up message)
 * 
 * @author Tristan Perrot
 *
 */
public class NoPathException {
	public static void throwNoPathPopUp() {
		JOptionPane.showInternalOptionDialog(null, "Il n'y a pas de solution à ce labyrinthe", "Erreur",
				JOptionPane.CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null, null, null);
	}
}
