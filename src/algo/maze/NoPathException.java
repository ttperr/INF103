package algo.maze;

public class NoPathException extends Exception {
	private static final long serialVersionUID = 1L;

	public NoPathException(String fileName) {
		super("Error : maze from " + fileName + " has no solution !");
	}
}
