package algo.maze;

public class DepartureArrivalException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * L�ve une exception s'il n'y a pas une seule arriv�e et un seul depart
	 * 
	 * @param message Message d'erreur
	 */
	public DepartureArrivalException(int row, int column, String message) {
		super("Erreur lors de la recherche du point de d�part et d'arriv�e � la ligne " + row + " et la colonne "
				+ column + " : " + message);
	}
}
