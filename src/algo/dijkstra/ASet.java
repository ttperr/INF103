package algo.dijkstra;

import java.util.HashSet;

/**
 * Classe de l'ensemble A de l'algorithme de Dijkstra
 * 
 * @author Tristan Perrot
 *
 */
public class ASet extends HashSet<VertexInterface> implements ASetInterface {

	private static final long serialVersionUID = 1L;

	public ASet() {
		super();
	}

	/**
	 * Ajout un sommet � A
	 * 
	 * @param vertex Le sommet � ajouter � A
	 */
	public void addVertex(VertexInterface vertex) {
		this.add(vertex);
	}

	/**
	 * Renvoie le test le bool�en indiquant un sommet est dans A
	 * 
	 * @param vertex Le sommet consid�r�
	 */
	public Boolean containsVertex(VertexInterface vertex) {
		return this.contains(vertex);
	}

}
