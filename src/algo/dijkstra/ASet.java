package algo.dijkstra;

import java.util.HashSet;

/**
 * A set class of the Dijkstra algorithm
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
	 * Add a vertex to A
	 * 
	 * @param vertex The vertex to add to A
	 */
	public void addVertex(VertexInterface vertex) {
		this.add(vertex);
	}

	/**
	 * Return the boolean test if A contains the vertex vertex
	 * 
	 * @param vertex The vertex to test
	 * 
	 * @return true if vertex is in A, false if not
	 */
	public Boolean containsVertex(VertexInterface vertex) {
		return this.contains(vertex);
	}
}
