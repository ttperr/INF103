package dijkstra;

import java.util.Hashtable;

public class Previous implements PreviousInterface {

	private final Hashtable<VertexInterface, VertexInterface> hashtable = new Hashtable<VertexInterface, VertexInterface>() ;
	
	public void setPrevious(VertexInterface x, VertexInterface previous) {
		hashtable.put(x, previous);		
	}

	public VertexInterface getPrevious(VertexInterface x) {
		return hashtable.get(x);
	}

	
}
