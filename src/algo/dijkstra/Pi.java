package algo.dijkstra;

import java.util.Hashtable;

/**
 * Pi function class of the Dijkstra algorithm
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
	 * Set a pi value for a vertex
	 * 
	 * @param vertex The vertex considered
	 * @param value  The value to give for pi(vertex)
	 **/
	@Override
	public void setPi(VertexInterface vertex, Integer value) {
		this.put(vertex, value);
	}

	/**
	 * Return the value of pi for a vertex
	 * 
	 * @param vertex The vertex considered
	 * @return The value of pi(vertex)
	 **/
	@Override
	public Integer getPi(VertexInterface vertex) {
		return this.get(vertex);
	}
}
