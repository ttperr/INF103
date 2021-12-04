package dijkstra;

import java.util.Hashtable;

public class Previous implements PreviousInterface {

	private final Hashtable<VertexInterface, VertexInterface> hashtable = new Hashtable<VertexInterface, VertexInterface>() ;
	
	// set the previous of a Vertex x
	public void setPrevious(VertexInterface x, VertexInterface previous) {
		hashtable.put(x, previous);		
	}
	
	// get the previous of a Vertex x
	public VertexInterface getPrevious(VertexInterface x) {
		return hashtable.get(x);
	}

	
}
