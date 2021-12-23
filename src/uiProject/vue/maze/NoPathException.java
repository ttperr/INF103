package uiProject.vue.maze;

import javax.swing.JOptionPane;

public class NoPathException {
	public static void throwNoPathPopUp() {
        JOptionPane.showMessageDialog(null,
               "Il n'y a pas de solution à ce labyrinthe",
               "Erreur",
               JOptionPane.ERROR_MESSAGE);
   }
}
