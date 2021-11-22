package Interface;

public interface VertexInterface {
	
	// return true if this vertex is equal to vertex x, false if not
	public Boolean isEqualTo(VertexInterface x) ;
	
	// return true if the vertex x is in A, false if not
	public Boolean isInA(ASetInterface a) ;
	
	//return the coordinates of a vertex like '(x,y)'
	public String getLabel();
	
}
