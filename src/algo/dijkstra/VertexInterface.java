package algo.dijkstra;

/**
 * Vertex interface
 * 
 * @author Tristan Perrot
 *
 */
public interface VertexInterface {

	/**
	 * Return the equality test beteween two vertices
	 * 
	 * @return The equality test between two vertices
	 */
	public Boolean isEqualTo(VertexInterface vertex);

	/**
	 * Return the label of a vertex
	 * 
	 * @return The string of the vertex
	 */
	public String getLabel();

}
