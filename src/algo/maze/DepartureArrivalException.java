package algo.maze;

public class DepartureArrivalException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Lève une exception s'il n'y a pas une seule arrivée et un seul depart
	 * 
	 * @param message Message d'erreur
	 */
	public DepartureArrivalException(int row, int column, String message) {
		super("Erreur lors de la recherche du point de départ et d'arrivée à la ligne " + row + " et la colonne "
				+ column + " : " + message);
	}
}
