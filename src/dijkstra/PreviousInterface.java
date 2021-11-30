package dijkstra;

public interface PreviousInterface {
	
	// set the previous of a Vertex x
	public void setPrevious(VertexInterface x, VertexInterface previous) ;
	
	// get the previous of a Vertex x
	public VertexInterface getPrevious(VertexInterface x) ;
	
}
