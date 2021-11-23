package Interface;

public interface ASetInterface {
	
	// return true if A is empty, false if not
	public Boolean isEmpty() ;
	
	// add a vertex to A
	public void addVertex(VertexInterface vertex) ;
	
	// return true if vertex is in A 
	public Boolean containsVertex(VertexInterface vertex) ;

}
