package dijkstra;

import java.util.Hashtable;

public class Pi implements PiInterface{
	private final Hashtable<VertexInterface, Integer> hashtable = new Hashtable<VertexInterface, Integer>() ;

	public void setPi(VertexInterface x, Integer c) {
		hashtable.put(x, c);
	}

	public Integer getPi(VertexInterface x) {
		return hashtable.get(x);
	}

}
