package maze;

import java.util.ArrayList;

import Interface.VertexInterface;

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
		return "(" + row + "," + column + ")";
	}
	
	public Double getWeight(VertexInterface src, VertexInterface dst) {
		ArrayList<VertexInterface> srcSuccessors = maze.getSuccessors(src);
		return (srcSuccessors.contains(dst)) ? 1 : Double.POSITIVE_INFINITY;
	}
	
	public Boolean isEqualTo(VertexInterface vertex) {
		MBox box = (MBox)vertex;
		return row == box.getRow() && column == box.getColumn();
	}
	
}
