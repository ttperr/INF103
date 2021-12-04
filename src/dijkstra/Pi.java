package dijkstra;

import java.util.Hashtable;

public class Pi implements PiInterface{
	
	private final Hashtable<VertexInterface, Integer> hashtable = new Hashtable<VertexInterface, Integer>() ;

	// set the value c of the function Pi for a Vertex x
	public void setPi(VertexInterface x, Integer c) {
		hashtable.put(x, c);
	}
	
	// return the value of the function Pi for a Vertex
	public Integer getPi(VertexInterface x) {
		return hashtable.get(x);
	}

}
