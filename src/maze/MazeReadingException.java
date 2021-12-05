package maze;

/** Erreur qui a lieu pendant la lecture du fichier texte d'initialisation
 * 
 * @author Tristan Perrot
 *
 */
public class MazeReadingException extends Exception {
	
	private static final long serialVersionUID = 1L ;

	/** Renvoie les informations li�es � l'erreur lev�e telle que la position et la nature
	 * @param fileName Adresse du fichier
	 * @param row Num�ro de la ligne
	 * @param column Num�ro de la colonne
	 * @param error Nature de l'erreur
	 */
	public MazeReadingException(String fileName, int row, int column, String error) {
		super("Erreur d�tect�e pendant la lecture du labyrinthe dans " + fileName + "(" + row + "," + column + ") : " + error) ;
	}
}
