package dijkstra;

/**
 * Interface de la fonction pi de l'algorithme Dijkstra
 * 
 * @author Tristan Perrot
 *
 */
public interface PiInterface {

	/**
	 * Assigne une valeur de pi à un sommet
	 * 
	 * @param vertex Le sommet considéré
	 * @param value  La valeur donné
	 */
	public void setPi(VertexInterface vertex, Integer value);

	/**
	 * Renvoie la valeur de pi pour un sommet
	 * 
	 * @param vertex Le sommet considéré
	 * @return La valeur de pi(vertex)
	 **/
	public Integer getPi(VertexInterface vertex);

}
