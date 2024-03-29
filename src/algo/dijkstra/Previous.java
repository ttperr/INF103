package algo.dijkstra;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Vertex previous class of the Dijkstra algorithm
 *
 * @author Tristan Perrot
 *
 */
public class Previous extends Hashtable<VertexInterface, VertexInterface> implements PreviousInterface {
	private static final long serialVersionUID = 1L;

	public Previous() {
		super();
	}

	/**
	 * Define the succession link between two vertices
	 *
	 * @param vertex   The son vertex
	 * @param previous The father vertex
	 **/
	@Override
	public final void setPrevious(VertexInterface x, VertexInterface previous) {
		this.put(x, previous);
	}

	/**
	 * Return the father of a vertex
	 *
	 * @param vertex The son vertex
	 * @return The father vertex
	 **/
	@Override
	public final VertexInterface getPrevious(VertexInterface x) {
		return this.get(x);
	}

	/**
	 * Return the shortest path to a vertex by vertex list from beginning to end
	 *
	 * @param vertex The arrival vertex
	 * @return The vertices list who represent the path to the vertex
	 */
	@Override
	public final ArrayList<VertexInterface> getShortestPathTo(VertexInterface vertex) {
		ArrayList<VertexInterface> path = new ArrayList<>();
		while (vertex != null) {
			path.add(vertex);
			vertex = getPrevious(vertex);
		}
		return path;
	}
}
