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
	 * Ajout un sommet à A
	 * 
	 * @param vertex Le sommet à ajouter à A
	 */
	public void addVertex(VertexInterface vertex) {
		this.add(vertex);
	}

	/**
	 * Renvoie le test le booléen indiquant un sommet est dans A
	 * 
	 * @param vertex Le sommet considéré
	 */
	public Boolean containsVertex(VertexInterface vertex) {
		return this.contains(vertex);
	}

}
