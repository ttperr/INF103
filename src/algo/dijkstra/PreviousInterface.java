package algo.dijkstra;

import java.util.ArrayList;

/**
 * Vertex previous interface
 * 
 * @author Tristan Perrot
 *
 */
public interface PreviousInterface {

	/**
	 * Define the succession link between two vertices
	 * 
	 * @param vertex   The son vertex
	 * @param previous The father vertex
	 **/
	public void setPrevious(VertexInterface x, VertexInterface previous);

	/**
	 * Return the father of a vertex
	 * 
	 * @param vertex The son vertex
	 * @return The father vertex
	 **/
	public VertexInterface getPrevious(VertexInterface x);

	/**
	 * Return the shortest path to a vertex by vertex list from beginning to end
	 * 
	 * @param vertex The arrival vertex
	 * @return The vertices list who represent the path to the vertex
	 */
	public ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex);

}
