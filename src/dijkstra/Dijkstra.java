package dijkstra;

import java.util.ArrayList;

public class Dijkstra {
	public PreviousInterface dijkstra(GraphInterface g, VertexInterface r) {
		ASet a = new ASet();
		Pi pi = new Pi();
		Previous previous = new Previous();
		
		a.addVertex(r);
		VertexInterface pivot = r;
		pi.setPi(r, (int) 0.0);
		
		ArrayList<VertexInterface> vertexArrayList = g.getAllVertices();
		int n = vertexArrayList.size();
		
		Integer posInf = Integer.MAX_VALUE ;
		
		for (VertexInterface x : vertexArrayList) {
			if (Boolean.FALSE.equals((x.isEqualTo(r))) ) pi.setPi(x, posInf);
		}
		
		for (int j = 1; j < n; j++) {
			for (VertexInterface y : g.getSuccessors(pivot)) {
				if (Boolean.FALSE.equals((a.containsVertex(y)))) {
					if ( (pi.getPi(pivot) + g.getWeight(pivot, y)) < pi.getPi(y) ) {
						pi.setPi(y, (int) (pi.getPi(pivot) + g.getWeight(pivot, y)));
						previous.setPrevious(y, pivot);
					}
				}
			}
			
			Integer minPi = posInf ;
			VertexInterface nextPivot = null ;
			
			for (VertexInterface y : vertexArrayList) {
				if (Boolean.FALSE.equals((a.containsVertex(y))) && (minPi > pi.getPi(y))) {
					minPi = pi.getPi(y) ;
					nextPivot = y ;
				}
			}
			
			pivot = nextPivot;
			a.addVertex(pivot);
		}
		
		return previous ;
		
	}
}
