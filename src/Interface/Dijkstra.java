package tp04;

import java.util.ArrayList;

public class Dijkstra {
	public PreviousInterface dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, PiInterface pi, PreviousInterface previous) {
		a.addVertex(r);
		VertexInterface pivot = r;
		pi.setPi(r, 0.0);
		
		ArrayList<VertexInterface> vertexArrayList = g.getAllVertices();
		int n = vertexArrayList.size();
		
		Double posInf = Double.POSITIVE_INFINITY ;
		
		for (VertexInterface x : vertexArrayList) {
			if (Boolean.FALSE.equals((x.isEqualTo(r))) ) pi.setPi(x, posInf);
		}
		
		for (int j = 1; j < n; j++) {
			for (VertexInterface y : g.getSuccessors(pivot)) {
				if (Boolean.FALSE.equals((y.isInA(a)))) {
					if ( (pi.getPi(pivot) + g.getWeight(pivot, y)) < pi.getPi(y) ) {
						pi.setPi(y, pi.getPi(pivot) + g.getWeight(pivot, y));
						previous.setPrevious(y, pivot);
					}
				}
			}
			
			Double minPi = posInf ;
			VertexInterface nextPivot = null ;
			
			for (VertexInterface y : vertexArrayList) {
				if (Boolean.FALSE.equals((y.isInA(a))) && (minPi > pi.getPi(y))) {
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
