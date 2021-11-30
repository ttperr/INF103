package maze;

public class MazeReadingException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5233076169935021206L;

	public MazeReadingException(String filename, int row, int column, String error) {
		super(error);
	}
}
