package algo.dijkstra;

import java.util.ArrayList;

/**
 * Graph interface
 * 
 * @author Tristan Perrot
 *
 */
public interface GraphInterface {

	/**
	 * Return the set of all graph vertices
	 * 
	 * @return The list of all the vertices
	 **/
	public ArrayList<VertexInterface> getAllVertices();

	/**
	 * Return the neighbor list of a vertex in the graph
	 * 
	 * @param vertex The vertex whose neighbors we are looking for
	 * @return The neighbors list
	 **/
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);

	/**
	 * Return the weight in the graph of an edge between two vertices
	 * 
	 * @param src The origin vertex
	 * @param dst The arrival vertex
	 * @returnThe weight of the edge src-dst
	 **/
	public Double getWeight(VertexInterface src, VertexInterface dst);

}
