package algo.dijkstra;

/**
 * A set class of the Dijkstra algorithm
 *
 * @author Tristan Perrot
 *
 */
public interface ASetInterface {

	/**
	 * Add a vertex to A
	 *
	 * @param vertex The vertex to add to A
	 */
	public void addVertex(VertexInterface vertex);

	/**
	 * Return the boolean test if A contains the vertex vertex
	 *
	 * @param vertex The vertex to test
	 *
	 * @return true if vertex is in A, false if not
	 */
	public Boolean containsVertex(VertexInterface vertex);
}
