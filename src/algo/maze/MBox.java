package algo.maze;

import algo.dijkstra.VertexInterface;

/**
 * Classe des cases du labyrinthes
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
	 * @return Le num�ro de ligne de la case
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return Le num�ro de colonne de la case
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return Le caract�re correspondant au type de la case
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return Le test d'�galit� entre 2 sommet
	 */
	public Boolean isEqualTo(VertexInterface vertex) {
		MBox box = (MBox) vertex;
		return row == box.getRow() && column == box.getColumn();
	}

}
