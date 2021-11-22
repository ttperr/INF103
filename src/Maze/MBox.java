package tp04;

public abstract class MBox implements VertexInterface {
	
	private final Maze maze;
	private final int row, column;
	
	public MBox(int i, int j, Maze maze) {
		this.maze = maze;
		row = i;
		column = j;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public Maze getMaze() {
		return maze;
	}
	
	public String getLabel() {
		return "(" + getRow() + "," + getColumn() + ")";
	}
	
}
