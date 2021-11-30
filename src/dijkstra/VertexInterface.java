package dijkstra;

public interface VertexInterface {
	
	// return true if this vertex is equal to vertex x, false if not
	public Boolean isEqualTo(VertexInterface vertex) ;
	
	//return the coordinates of a vertex like '(x,y)'
	public String getLabel();
	
}