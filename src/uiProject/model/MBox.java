package uiProject.model;

/**
 * Classe des cases du labyrinthes nécessaire pour l'interface graphique
 * 
 * @author Tristan Perrot
 *
 */
public class Box {
	private final int row;
	private final int column;
	private final String label;
	
	protected Box(int i, int j, String label) {
		row = i;
		column = j;
		this.label = label;
	}

	/**
	 * @return Le numéro de la ligne de la case
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return Le numéro de la colonne de la case
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * @return Le caractère correspondant au type de la case
	 */
	public String getLabel() {
		return label;
	}
	
}
