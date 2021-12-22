package algo.dijkstra;

import java.util.ArrayList;

/**
 * Classe de l'algorithme Dijkstra
 * 
 * @author Tristan Perrot
 *
 */
public final class Dijkstra {

	/**
	 * For a graph and a vertex given, return what contains the shortest path to the
	 * origin vertex
	 * 
	 * @param g The graph considered
	 * @param r The origin vertex
	 * 
	 * @return Previous
	 **/
	public final static PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		ASet a = new ASet();
		Pi pi = new Pi();
		Previous previous = new Previous();

		a.addVertex(r);
		VertexInterface pivot = r;
		pi.setPi(r, (int) 0.0);

		ArrayList<VertexInterface> allVertices = g.getAllVertices();

		Integer posInf = Integer.MAX_VALUE;

		for (VertexInterface x : allVertices) {
			if (Boolean.FALSE.equals((x.isEqualTo(r))))
				pi.setPi(x, posInf);
		}

		for (@SuppressWarnings("unused")
		VertexInterface j : allVertices) {
			for (VertexInterface y : g.getSuccessors(pivot)) {
				if (Boolean.FALSE.equals((a.containsVertex(y)))) {
					if ((pi.getPi(pivot) + g.getWeight(pivot, y)) < pi.getPi(y)) {
						pi.setPi(y, (int) (pi.getPi(pivot) + g.getWeight(pivot, y)));
						previous.setPrevious(y, pivot);
					}
				}
			}

			Integer minPi = posInf;
			VertexInterface nextPivot = null;

			for (VertexInterface vertex : allVertices) {
				if (!(a.containsVertex(vertex)) && (minPi > pi.getPi(vertex))) {
					minPi = pi.getPi(vertex);
					nextPivot = vertex;
				}
			}
			if (nextPivot == null) {
				break;
			} else {
				pivot = nextPivot;
				a.addVertex(pivot);
			}
		}
		return previous;
	}
}
