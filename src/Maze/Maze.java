package Maze;

import java.util.ArrayList;
import Interface.GraphInterface;

public final class Maze implements GraphInterface {
	private ArrayList<ArrayList<MBox>> boxes;
	
	public MBox getBox(int i, int j) {
		return boxes.get(i).get(j);
	}
	
	public ArrayList<VertexInterface> getAllVertices() {
		ArrayList<VertexInterface> vertices = new ArrayList<VertexInterface>();
		
		for (ArrayList<MBox> listMBox : boxes) {
			for(MBox box : listMBox) {
				vertices.add(box);
			}
		}
		
		return vertices;
	}
	
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();
		MBox box = (MBox)vertex ;
		int row = box.getRow();
		
		for(MBox succBox: boxes.get(row)) {
			VertexInterface succVertex = (VertexInterface)succBox;
			Double weight = getWeight(vertex, succVertex);
			Double posInf = Double.POSITIVE_INFINITY ;
			if (weight < posInf) {
				successors.add(succVertex);
			}
		}
		
		return successors;
	}
	
	public Double getWeight(VertexInterface src,VertexInterface dst) {
		return null;
	}
	
}
