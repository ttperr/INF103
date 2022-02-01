package algo.maze;

/**
 * Departure and Arrival Exception
 * 
 * @author Tristan Perrot
 *
 */
public final class DepartureArrivalException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Throw an exception if there is not only one arrival and one departure
	 * 
	 * @param message The error message
	 */
	public DepartureArrivalException(int row, int column, String message) {
		super("Error when the research of arrival and departure point on the row " + row + " and the column " + column
				+ " : " + message);
	}
}
