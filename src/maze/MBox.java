package maze;

import dijkstra.VertexInterface;

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
	 * Renvoie le num�ro de ligne de la case
	 * 
	 * @return Num�ro de ligne de la case
	 */
	public int getRow() {
		return row;
	}

	/**
	 * Renvoie le num�ro de colomne de la case
	 * 
	 * @return Num�ro de colomne de la case
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * Renvoie le label du sommet
	 * 
	 * @return Le caract�re correspondant au type de la case
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Renvoie le test d'�galit� entre 2 sommet
	 * 
	 * @return Le test d'�galit� entre 2 sommet
	 */
	public Boolean isEqualTo(VertexInterface vertex) {
		MBox box = (MBox) vertex;
		return row == box.getRow() && column == box.getColumn();
	}

}
