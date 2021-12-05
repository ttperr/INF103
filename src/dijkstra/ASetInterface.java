package dijkstra;

/**
 * Interface de l'ensemble de A de l'algorithme de Dijkstra
 * 
 * @author Tristan Perrot
 *
 */
public interface ASetInterface {

	/**
	 * Ajout un sommet à A
	 * 
	 * @param vertex Le sommet à ajouter à A
	 */
	public void addVertex(VertexInterface vertex);

	/**
	 * Renvoie le test le booléen indiquant un sommet est dans A
	 * 
	 * @param vertex Le sommet considéré
	 */
	public Boolean containsVertex(VertexInterface vertex);

}
