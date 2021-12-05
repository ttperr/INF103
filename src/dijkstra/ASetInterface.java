package dijkstra;

/**
 * Interface de l'ensemble de A de l'algorithme de Dijkstra
 * 
 * @author Tristan Perrot
 *
 */
public interface ASetInterface {

	/**
	 * Ajout un sommet � A
	 * 
	 * @param vertex Le sommet � ajouter � A
	 */
	public void addVertex(VertexInterface vertex);

	/**
	 * Renvoie le test le bool�en indiquant un sommet est dans A
	 * 
	 * @param vertex Le sommet consid�r�
	 */
	public Boolean containsVertex(VertexInterface vertex);

}
