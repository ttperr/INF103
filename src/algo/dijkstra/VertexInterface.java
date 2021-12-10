package algo.dijkstra;

/**
 * Interface des sommets
 * 
 * @author Tristan Perrot
 *
 */
public interface VertexInterface {

	/**
	 * Renvoie le test d'égalité entre 2 sommet
	 * 
	 * @return Le test d'égalité entre 2 sommet
	 */
	public Boolean isEqualTo(VertexInterface vertex);

	/**
	 * Renvoie le label du sommet
	 * 
	 * @return Le caractère correspondont au type de la case
	 */
	public String getLabel();

}
