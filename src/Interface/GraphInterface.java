package tp04;

import java.util.ArrayList;

public interface GraphInterface {
	
	// return all the graph's vertex
	public ArrayList<VertexInterface> getAllVertices() ;
	
	// return a list of Vertex of the vertex's neighbors given in entry
	public ArrayList<VertexInterface> getSuccessors(VertexInterface x) ;
	
	// return the weight of an edge (x,y)
	public Double getWeight(VertexInterface x, VertexInterface y) ;
	
}
