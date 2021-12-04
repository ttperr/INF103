package dijkstra;

import java.util.HashSet;

public class ASet implements ASetInterface {

	private final HashSet<VertexInterface> hashSet = new HashSet<VertexInterface>() ;
	
	// return true if A is empty, false if not
	public Boolean isEmpty() {
		return hashSet.isEmpty() ;
	}
	
	// add a vertex to A
	public void addVertex(VertexInterface vertex) {
		hashSet.add(vertex) ;
	}

	// return true if vertex is in A 
	public Boolean containsVertex(VertexInterface vertex) {
		return hashSet.contains(vertex) ;
	}
	
}
