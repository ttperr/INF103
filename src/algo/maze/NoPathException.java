package algo.maze;

/**
 * Exception throwed when there is no path for the maze
 * 
 * @author Tristan Perrot
 *
 */
public final class NoPathException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Exception throwed when there is no path for the maze
	 * 
	 * @param fileName the origin of the maze
	 */
	public NoPathException(String fileName) {
		super("Error : maze from " + fileName + " has no solution !");
	}
}
