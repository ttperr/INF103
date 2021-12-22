package algo.maze;

/**
 * Exception link to the initializing file reading
 * 
 * @author Tristan Perrot
 *
 */
public class MazeReadingException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Return the detail of the reading file exception like the position and the
	 * nature
	 * 
	 * @param fileName File adress
	 * @param row      Line number
	 * @param column   Column number
	 * @param error    Error nature
	 */
	public MazeReadingException(String fileName, int row, int column, String error) {
		super("Erreur détectée pendant la lecture du labyrinthe dans " + fileName + "(" + row + "," + column + ") : "
				+ error);
	}
}
