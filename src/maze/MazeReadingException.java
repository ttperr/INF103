package maze;

/** Erreur qui a lieu pendant la lecture du fichier texte d'initialisation
 * 
 * @author Tristan Perrot
 *
 */
public class MazeReadingException extends Exception {
	
	private static final long serialVersionUID = 1L ;

	/** Renvoie les informations liées à l'erreur levée telle que la position et la nature
	 * @param fileName Adresse du fichier
	 * @param row Numéro de la ligne
	 * @param column Numéro de la colonne
	 * @param error Nature de l'erreur
	 */
	public MazeReadingException(String fileName, int row, int column, String error) {
		super("Erreur détectée pendant la lecture du labyrinthe dans " + fileName + "(" + row + "," + column + ") : " + error) ;
	}
}
