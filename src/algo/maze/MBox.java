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
	public final int getRow() {
		return row;
	}

	/**
	 * @return Box column number
	 */
	public final int getColumn() {
		return column;
	}

	/**
	 * @return The box label
	 */
	@Override
	public final String getLabel() {
		return label;
	}

	/**
	 * @return The equality test between two vertices
	 */
	@Override
	public final Boolean isEqualTo(VertexInterface vertex) {
		MBox box = (MBox) vertex;
		return row == box.getRow() && column == box.getColumn();
	}
}
