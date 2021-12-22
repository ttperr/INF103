package algo.dijkstra;

/**
 * Pi function interface of the Dijkstra algorithm
 * 
 * @author Tristan Perrot
 *
 */
public interface PiInterface {

	/**
	 * Set a pi value for a vertex
	 * 
	 * @param vertex The vertex considered
	 * @param value  The value to give for pi(vertex)
	 **/
	public void setPi(VertexInterface vertex, Integer value);

	/**
	 * Return the value of pi for a vertex
	 * 
	 * @param vertex The vertex considered
	 * @return The value of pi(vertex)
	 **/
	public Integer getPi(VertexInterface vertex);

}
