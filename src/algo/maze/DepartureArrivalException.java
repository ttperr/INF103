package algo.maze;
/**
 * Departure and Arrival Exception
 * 
 * @author Tristan Perrot
 *
 */
public class DepartureArrivalException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Throw an exception if there is not only one arrival and one departure
	 * 
	 * @param message The error message
	 */
	public DepartureArrivalException(int row, int column, String message) {
		super("Erreur lors de la recherche du point de départ et d'arrivée à la ligne " + row + " et la colonne "
				+ column + " : " + message);
	}
}
