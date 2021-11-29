package maze;

public class MazeReadingException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filename;
	private int row;
	private int column;
	private String error;
	
	public MazeReadingException(String filename, int row, int column, String error) {
		super(error);
	}
}
