package dijkstra;

import java.util.Hashtable;

/**
 * Classe de la fonction pi de l'algorithme de Dijkstra
 * 
 * @author Tristan Perrot
 *
 */
public class Pi extends Hashtable<VertexInterface, Integer> implements PiInterface {

	private static final long serialVersionUID = 1L;

	public Pi() {
		super();
	}

	/**
	 * Assigne une valeur de pi � un sommet
	 * 
	 * @param vertex Le sommet consid�r�
	 * @param value  La valeur donn�e � pi(vertex)
	 **/
	public void setPi(VertexInterface vertex, Integer value) {
		this.put(vertex, value);
	}

	/**
	 * Renvoie la valeur de pi pour un sommet
	 * 
	 * @param vertex Le sommet consid�r�
	 * @return La valeur de pi(vertex)
	 **/
	public Integer getPi(VertexInterface vertex) {
		return this.get(vertex);
	}

}
