package algo.maze;

import algo.dijkstra.VertexInterface;

/**
 * Maze boxes class
 * 
 * @author Tristan Perrot
 *
 */
public abstract class MBox implements VertexInterface {

	private final int row;
	private final int column;
	private final String label;

	protected MBox(int i, int j, String label) {
		row = i;
		column = j;
		this.label = label;
	}

	/**
	 * @return Box line number
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return Box column number
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return The box label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return The equality test between two vertices
	 */
	public Boolean isEqualTo(VertexInterface vertex) {
		MBox box = (MBox) vertex;
		return row == box.getRow() && column == box.getColumn();
	}
}
