package dijkstra;

import java.util.HashSet;

public class ASet implements ASetInterface {

	private final HashSet<VertexInterface> hashSet = new HashSet<VertexInterface>() ;
	
	public Boolean isEmpty() {
		return hashSet.isEmpty() ;
	}
	
	public void addVertex(VertexInterface vertex) {
		hashSet.add(vertex) ;
	}

	public Boolean containsVertex(VertexInterface vertex) {
		return hashSet.contains(vertex) ;
	}
	
}
