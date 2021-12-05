package dijkstra;

/**
 * Interface de la fonction pi de l'algorithme Dijkstra
 * 
 * @author Tristan Perrot
 *
 */
public interface PiInterface {

	/**
	 * Assigne une valeur de pi � un sommet
	 * 
	 * @param vertex Le sommet consid�r�
	 * @param value  La valeur donn�
	 */
	public void setPi(VertexInterface vertex, Integer value);

	/**
	 * Renvoie la valeur de pi pour un sommet
	 * 
	 * @param vertex Le sommet consid�r�
	 * @return La valeur de pi(vertex)
	 **/
	public Integer getPi(VertexInterface vertex);

}
